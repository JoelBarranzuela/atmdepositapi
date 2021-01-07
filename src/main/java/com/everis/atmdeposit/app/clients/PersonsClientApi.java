package com.everis.atmdeposit.app.clients;


import com.everis.atmdeposit.app.entity.PersonResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonsClientApi {
  
  @GET("/core/persons")
  Single<PersonResponse> findByDocumentNumber(@Query("documentNumber")String documentNumber);

}
