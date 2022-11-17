package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solutions")
public class ServiceDeviceController {

  private ServiceDeviceService serviceDeviceService;

  @Autowired
  public void setSolutionService(
      ServiceDeviceService serviceDeviceService) {
    this.serviceDeviceService = serviceDeviceService;
  }

  @GetMapping("/{id}")
  public Optional<ServiceDevice> findSolutionById(@PathVariable Long id) {
    return serviceDeviceService.getServiceById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ServiceDevice createSolution(@RequestBody ServiceDevice serviceDevice) {
    return serviceDeviceService.addService(serviceDevice);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ServiceDevice> updateSolution(@PathVariable Long id,
      @RequestBody ServiceDevice serviceDevice) {
    Optional<ServiceDevice> solutionOptional = serviceDeviceService.updateService(id, serviceDevice);
    return solutionOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void deleteSolution(@PathVariable Long id) {
    serviceDeviceService.deleteService(id);
  }
}
