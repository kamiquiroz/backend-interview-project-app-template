package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
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


@Api(value = "ServiceAssignment Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Service Assignments"})
@RequestMapping("/service-assignments")
public interface ServiceAssignmentApi {

  @Operation(summary = "Get a ServiceAssignment.", description = "Get a ServiceAssignment.", tags = {"Service Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<ServiceAssignment> findServiceAssignment(
      @Parameter(required = true, description = "ServiceAssignment Id.") @PathVariable Long id);

  @Operation(summary = "Get all ServiceAssignments.", description = "Get all ServiceAssignments.", tags = {"Service Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<ServiceAssignment> findAllServiceAssignments();

  @Operation(summary = "Create a ServiceAssignment.", description = "Create a ServiceAssignment.", tags = {"Service Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  ServiceAssignment createServiceAssignment(@RequestBody ServiceAssignment serviceAssignment);

  @Operation(summary = "Update a ServiceAssignment.", description = "Update a ServiceAssignment.", tags = {"Service Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<ServiceAssignment> updateServiceAssignment(@PathVariable Long id, @RequestBody ServiceAssignment serviceAssignment);

  @Operation(summary = "Delete a ServiceAssignment.", description = "Delete a ServiceAssignment.", tags = {"Service Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteServiceAssignment(@PathVariable Long id);

}
