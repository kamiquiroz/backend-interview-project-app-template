package com.ninjaone.backendinterviewproject.api;

import com.ninjaone.backendinterviewproject.model.Type;
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

@Api(value = "Type Management", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Types"})
@RequestMapping("/types")
public interface TypeApi {

  @Operation(summary = "Get a Type.", description = "Get a Type.", tags = {"Types"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping("/{id}")
  ResponseEntity<Type> findType(
      @Parameter(required = true, description = "Type Id.") @PathVariable Long id);

  @Operation(summary = "Get all Types.", description = "Get all Types.", tags = {"Types"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @GetMapping()
  List<Type> findAllTypes();

  @Operation(summary = "Create a Type.", description = "Create a Type.", tags = {"Types"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PostMapping
  Type createType(@RequestBody Type type);

  @Operation(summary = "Update a Type.", description = "Update a Type.", tags = {"Types"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @PutMapping("/{id}")
  ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type type);

  @Operation(summary = "Delete a Type.", description = "Delete a Type.", tags = {"Types"})
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "Not Found"),
      @ApiResponse(responseCode = "500", description = "Server Error")})
  @DeleteMapping("/{id}")
  void deleteType(@PathVariable Long id);
}
