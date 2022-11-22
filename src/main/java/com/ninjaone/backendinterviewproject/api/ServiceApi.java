package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.Service;
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

@Api(value = "Service Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Services"})
@RequestMapping("/services")
public interface ServiceApi {

  @Operation(summary = "Get a Service.", description = "Get a Service.", tags = {"Services"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<Service> findService(
      @Parameter(required = true, description = "Service Id.") @PathVariable Long id);

  @Operation(summary = "Get all Services.", description = "Get all Services.", tags = {"Services"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<Service> findAllServices();

  @Operation(summary = "Create a Service.", description = "Create a Service.", tags = {"Services"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  Service createService(@RequestBody Service service);

  @Operation(summary = "Update a Service.", description = "Update a Service.", tags = {"Services"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service service);

  @Operation(summary = "Delete a Service.", description = "Delete a Service.", tags = {"Services"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteService(@PathVariable Long id);
}
