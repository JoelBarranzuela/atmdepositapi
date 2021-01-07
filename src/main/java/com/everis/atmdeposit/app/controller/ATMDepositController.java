package com.everis.atmdeposit.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.everis.atmdeposit.app.clients.*;
import com.everis.atmdeposit.app.config.BlackListException;
import com.everis.atmdeposit.app.config.ErrorDetail;
import com.everis.atmdeposit.app.entity.*;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/atm/deposits/")
@Api(value = "ATM Deposits API")
public class ATMDepositController {
  @Autowired
  PersonsClientApi personsClientApi;
  @Autowired
  FingerPrintsClientApi fingerprintsClientApi;
  @Autowired
  ReniecClienteApi reniecClientApi;
  @Autowired
  CardClientApi cardsClientApi;
  @Autowired
  AccountsClientApi accountsClientApi;

  @ApiOperation(value = "Post request to retrieve client's info", response = ATMDepositResponse.class)
  @ApiResponses( value = {
  @ApiResponse(code = 200, message = "Successful operation", response = ATMDepositResponse.class),
  @ApiResponse(code = 401, message = "Invalid access, client in blacklist", response = ErrorDetail.class)} )
  @PostMapping
  public Single<ATMDepositResponse> getDeposits(
      @ApiParam("El Dni no puede estar vacio") @RequestBody ATMDepositRequest request)
      throws BlackListException {

    try {
      Single<PersonResponse> personMaybeBlacklist = personsClientApi.findByDocumentNumber(request.getDocumentNumber());
      PersonResponse personResponse = personMaybeBlacklist.blockingGet();
    } catch (Exception e) {
      throw new BlackListException("Cliente en lista negra");
    }

    Observable<ATMDepositResponse> atmResponse = personsClientApi.findByDocumentNumber(request.getDocumentNumber())
        .toObservable().map(p -> {
          List<Account> accountNumbers = new ArrayList<>();
          // Response initialization
          ATMDepositResponse response = new ATMDepositResponse();

          // Flag to validate fingerprints or reniec
          if (p.getFingerprint()) {
            response.setFingerprintEntityName(
                fingerprintsClientApi.FingerPrintValidate(request).blockingGet().getEntityName());
          } else {
            response.setFingerprintEntityName(reniecClientApi.validateReniecInfo(request).blockingGet().getEntityName());

          }

          // reducing total amount of accounts
          Double totalAmount = cardsClientApi.getAllCards(p.getDocumentNumber())
              .flatMap(list -> Observable.fromIterable(list.getCards())).filter(Card::getActive)
              .map(Card::getCardNumber).map(card -> accountsClientApi.getAllAccounts(card).toObservable())
              .flatMap(Observable::wrap).doOnNext(account -> {
                // side effect to collect list of accounts
                accountNumbers.add(new Account(account.getAccountNumber()));
              }).map(AccountResponse::getAmount).reduce(Double::sum).blockingGet();

          // set fields
          response.setValidAccounts(accountNumbers);
          response.setCustomerAmount(totalAmount);

          return response;
        });

    return atmResponse.elementAt(0, new ATMDepositResponse());
  }

}
