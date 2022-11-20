package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
import com.ninjaone.backendinterviewproject.service.ServiceAssignmentService;
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
@RequestMapping("/service-assignment")
public class ServiceAssignmentController {

  private ServiceAssignmentService serviceAssignmentService;

  @Autowired
  public void setServiceAssignmentService(ServiceAssignmentService serviceAssignmentService) {
    this.serviceAssignmentService = serviceAssignmentService;
  }

  @GetMapping("/{id}")
  public Optional<ServiceAssignment> findServiceAssignment(@PathVariable Long id) {
    return serviceAssignmentService.getServiceAssignment(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ServiceAssignment createServiceAssignment(
      @RequestBody ServiceAssignment serviceAssignment) {
    return serviceAssignmentService.addServiceAssignment(serviceAssignment);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ServiceAssignment> updateServiceAssignment(@PathVariable Long id,
      @RequestBody ServiceAssignment serviceAssignment) {
    Optional<ServiceAssignment> serviceAssignmentOptional = serviceAssignmentService.updateServiceAssignment(
        id, serviceAssignment);
    return serviceAssignmentOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void deleteServiceAssignment(@PathVariable Long id) {
    serviceAssignmentService.deleteServiceAssignment(id);
  }


}
