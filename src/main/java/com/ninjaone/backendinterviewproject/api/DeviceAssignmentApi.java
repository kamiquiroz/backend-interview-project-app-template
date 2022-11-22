package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
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


@Api(value = "DeviceAssignment Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Device Assignments"})
@RequestMapping("/device-assignments")
public interface DeviceAssignmentApi {

  @Operation(summary = "Get a DeviceAssignment.", description = "Get a DeviceAssignment.", tags = {"Device Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<DeviceAssignment> findDeviceAssignment(
      @Parameter(required = true, description = "DeviceAssignment Id.") @PathVariable Long id);

  @Operation(summary = "Get all DeviceAssignments.", description = "Get all DeviceAssignments.", tags = {"Device Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<DeviceAssignment> findAllDeviceAssignments();

  @Operation(summary = "Create a DeviceAssignment.", description = "Create a DeviceAssignment.", tags = {"Device Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  DeviceAssignment createDeviceAssignment(@RequestBody DeviceAssignment deviceAssignment);

  @Operation(summary = "Update a DeviceAssignment.", description = "Update a DeviceAssignment.", tags = {"Device Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<DeviceAssignment> updateDeviceAssignment(@PathVariable Long id, @RequestBody DeviceAssignment deviceAssignment);

  @Operation(summary = "Delete a DeviceAssignment.", description = "Delete a DeviceAssignment.", tags = {"Device Assignments"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteDeviceAssignment(@PathVariable Long id);

}
