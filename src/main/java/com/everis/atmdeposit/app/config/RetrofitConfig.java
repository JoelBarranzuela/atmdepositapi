package com.everis.atmdeposit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.everis.atmdeposit.app.clients.AccountsClientApi;
import com.everis.atmdeposit.app.clients.CardClientApi;
import com.everis.atmdeposit.app.clients.FingerPrintsClientApi;
import com.everis.atmdeposit.app.clients.PersonsClientApi;
import com.everis.atmdeposit.app.clients.ReniecClienteApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

  @Bean
  PersonsClientApi personsClientApi() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8090")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(PersonsClientApi.class);
  }

  @Bean
  CardClientApi cardsClientApi() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:9003")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(CardClientApi.class);
  }

  @Bean
  AccountsClientApi accountsClientApi() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:9001")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(AccountsClientApi.class);
  }

  @Bean
  FingerPrintsClientApi fingerprintsClientApi() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:9002")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(FingerPrintsClientApi.class);
  }

  @Bean
  ReniecClienteApi reniecClientApi() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:9004")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(ReniecClienteApi.class);
  }

}
