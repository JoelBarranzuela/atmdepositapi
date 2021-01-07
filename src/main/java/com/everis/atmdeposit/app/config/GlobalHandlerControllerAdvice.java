package com.everis.atmdeposit.app.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class GlobalHandlerControllerAdvice {
  @ExceptionHandler(BlackListException.class)
  public ResponseEntity<ErrorDetail> blacklistException(BlackListException e) {
    return new ResponseEntity<ErrorDetail>(new ErrorDetail(e.getMessage(), e.getDate()), HttpStatus.UNAUTHORIZED);
  }

}
