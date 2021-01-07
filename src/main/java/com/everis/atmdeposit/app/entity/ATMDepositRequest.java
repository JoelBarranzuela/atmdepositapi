package com.everis.atmdeposit.app.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ATMDepositRequest {
  @ApiModelProperty(notes = "DNI CLIENTE", example = "10000000")
  private String documentNumber;

}
