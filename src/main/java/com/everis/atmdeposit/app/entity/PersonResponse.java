package com.everis.atmdeposit.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
  private Integer id;
  private String documentNumber;
  private Boolean fingerprint;
  private Boolean blacklist;

}
