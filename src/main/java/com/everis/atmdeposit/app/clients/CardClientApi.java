package com.everis.atmdeposit.app.clients;

import com.everis.atmdeposit.app.entity.CardResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardClientApi {
  @GET("/core/cards")
  Observable<CardResponse> getAllCards(@Query("documentNumber") String documentNumber);
}
