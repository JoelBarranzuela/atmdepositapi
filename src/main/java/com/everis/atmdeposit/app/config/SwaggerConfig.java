package com.everis.atmdeposit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return changeGlobalResponses(
        new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.everis.atmdeposit.app"))
            .paths(PathSelectors.any()).build().apiInfo(metaData()));
  }

  @Bean
  public ApiInfo metaData() {
    return new ApiInfoBuilder().title("API REST ATM DEPOSIT").description("\"API REST ATM DEPOSIT\"").version("1.0.0")
        .license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
        .contact(new Contact("Joel Barranzuela", "https://github.com/JoelBarranzuela", "joejoel0512@gmail.com"))
        .build();
  }

  private Docket changeGlobalResponses(Docket docket) {
    docket = docket.useDefaultResponseMessages(false);
    return docket;
  }

}
