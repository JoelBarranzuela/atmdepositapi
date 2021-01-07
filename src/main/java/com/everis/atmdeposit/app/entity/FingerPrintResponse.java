package com.everis.atmdeposit.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FingerPrintResponse {
  
  private String entityName;
  private Boolean success;

}
