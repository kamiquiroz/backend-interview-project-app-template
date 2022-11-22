package com.ninjaone.backendinterviewproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Backend Interview Project")
                .description(
                    "This is the official documentation of the NinjaOne backend technical test.")
                .termsOfService("")
                .version("1.0.0")
                .license(new License().name("ninjaone.com"))
                .contact(
                    new io.swagger.v3.oas.models.info.Contact()
                        .email("kamiquiroz@gmail.com")));
  }

  /**
   * Method to configure the Basic API Info for Swagger Documentation.
   *
   * @return ApiInfo Object with API Configuration.
   */
  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Backend Engineer Task for NinjaOne",
        "Implement a REST API in Java with data persistence to fulfill the basic requirements of an RMM Platform.",
        "1.0",
        "Terms of service",
        new Contact("Karen Gomez Quiroz", "https://www.ninjaone.com/", "kamiquiroz@gmail.com"),
        "License of API",
        "API license URL",
        Collections.emptyList());
  }

  /**
   * Configuration method for Swagger, here we use the ApiInfo object and also set the Controller
   * Path.
   *
   * @return Docket Swagger Config.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("com.ninjaone.backendinterviewproject.controller"))
        .build();
  }

}
