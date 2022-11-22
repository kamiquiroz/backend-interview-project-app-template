package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.Device;
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


@Api(value = "Device Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Devices"})
@RequestMapping("/devices")
public interface DeviceApi {

  @Operation(summary = "Get a Device.", description = "Get a Device.", tags = {"Devices"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<Device> findDevice(
      @Parameter(required = true, description = "Device Id.") @PathVariable Long id);

  @Operation(summary = "Get all Devices.", description = "Get all Devices.", tags = {"Devices"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<Device> findAllDevices();

  @Operation(summary = "Create a Device.", description = "Create a Device.", tags = {"Devices"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  Device createDevice(@RequestBody Device device);

  @Operation(summary = "Update a Device.", description = "Update a Device.", tags = {"Devices"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device);

  @Operation(summary = "Delete a Device.", description = "Delete a Device.", tags = {"Devices"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteDevice(@PathVariable Long id);

}
