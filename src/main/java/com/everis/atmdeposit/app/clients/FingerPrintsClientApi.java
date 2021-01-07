package com.everis.atmdeposit.app.clients;

import com.everis.atmdeposit.app.entity.ATMDepositRequest;
import com.everis.atmdeposit.app.entity.FingerPrintResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FingerPrintsClientApi {
  @POST("/core/fingerprints/validate")
  Single<FingerPrintResponse> FingerPrintValidate(@Body ATMDepositRequest atmDepositRequest);

}
