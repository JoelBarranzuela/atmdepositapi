package com.everis.atmdeposit.app.clients;

import com.everis.atmdeposit.app.entity.ATMDepositRequest;
import com.everis.atmdeposit.app.entity.ReniecResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReniecClienteApi {
  @POST("/external/reniec/validate")
  Single<ReniecResponse> validateReniecInfo(@Body ATMDepositRequest atmDepositRequest);

}
