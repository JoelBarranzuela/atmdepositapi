package com.everis.atmdeposit.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReniecResponse {
  private String entityName;
  private Boolean success;
}
