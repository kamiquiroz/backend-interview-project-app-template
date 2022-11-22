package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.ServiceCost;
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


@Api(value = "ServiceCost Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Service Costs"})
@RequestMapping("/service-costs")
public interface ServiceCostApi {

  @Operation(summary = "Get a ServiceCost.", description = "Get a ServiceCost.", tags = {"Service Costs"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<ServiceCost> findServiceCost(
      @Parameter(required = true, description = "ServiceCost Id.") @PathVariable Long id);

  @Operation(summary = "Get all ServiceCosts.", description = "Get all ServiceCosts.", tags = {"Service Costs"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<ServiceCost> findAllServiceCosts();

  @Operation(summary = "Create a ServiceCost.", description = "Create a ServiceCost.", tags = {"Service Costs"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  ServiceCost createServiceCost(@RequestBody ServiceCost serviceCost);

  @Operation(summary = "Update a ServiceCost.", description = "Update a ServiceCost.", tags = {"Service Costs"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<ServiceCost> updateServiceCost(@PathVariable Long id, @RequestBody ServiceCost serviceCost);

  @Operation(summary = "Delete a ServiceCost.", description = "Delete a ServiceCost.", tags = {"Service Costs"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteServiceCost(@PathVariable Long id);

}
