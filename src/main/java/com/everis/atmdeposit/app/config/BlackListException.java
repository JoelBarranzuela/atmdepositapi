package com.everis.atmdeposit.app.config;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BlackListException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -9176604983790587943L;
  private String message;
  private Instant date;

  public BlackListException(String message) {
    this.message = message;
    this.date = Instant.now();
  }
}
