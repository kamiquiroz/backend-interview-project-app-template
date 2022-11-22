package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(value = "Customer Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Customers"})
@RequestMapping("/customers")
public interface CustomerApi {

  @Operation(summary = "Get a Customer.", description = "Get a Customer.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<Customer> findCustomer(
      @Parameter(required = true, description = "Customer Id.") @PathVariable Long id);

  @Operation(summary = "Get total monthly cost.", description = "Get total monthly cost.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{customerName}/monthly-cost")
  Double getMonthlyCostByCustomerName(
      @Parameter(required = true, description = "Customer Name.") @PathVariable String customerName);

  @Operation(summary = "Get all Customers.", description = "Get all Customers.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<Customer> findAllCustomers();

  @Operation(summary = "Create a Customer.", description = "Create a Customer.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  Customer createCustomer(@RequestBody Customer customer);

  @Operation(summary = "Update a Customer.", description = "Update a Customer.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer);

  @Operation(summary = "Delete a Customer.", description = "Delete a Customer.", tags = {"Customers"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteCustomer(@PathVariable Long id);

}
