package com.everis.atmdeposit.app.clients;

import com.everis.atmdeposit.app.entity.AccountResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccountsClientApi {

  @GET("/core/accounts")
  Single<AccountResponse> getAllAccounts(@Query("cardNumber")String documentNumber);
}
