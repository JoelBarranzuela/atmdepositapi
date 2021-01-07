package com.everis.atmdeposit.app.entity;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATMDepositResponse {
  
  @ApiModelProperty(notes = "Validar huella", example = "Core", position = 1)
  private String fingerprintEntityName;
  @ApiModelProperty(notes = "Clientes activos", example = "[\"1111222233334441XXX\",\"1111222233334442XXX\",\"1111222233334443XXX\"]", position = 2)
  private List<Account> validAccounts;
  @ApiModelProperty(notes = "Total de los clientes activos", example = "3000", position = 3)
  private Double customerAmount;

}
