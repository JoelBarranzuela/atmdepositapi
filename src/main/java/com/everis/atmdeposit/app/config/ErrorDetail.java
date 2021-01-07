package com.everis.atmdeposit.app.config;

import java.time.Instant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ApiModel("error")
public class ErrorDetail {
  @ApiModelProperty(value = "error msg", example = "cliente esta en blacklist")
  private String message;
  @ApiModelProperty(value = "error fecha")
  private Instant date;

}
