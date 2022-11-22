package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.ServiceAssignmentApi;
import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
import com.ninjaone.backendinterviewproject.service.ServiceAssignmentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAssignmentController implements ServiceAssignmentApi {

  private ServiceAssignmentService serviceAssignmentService;

  @Autowired
  public void setServiceAssignmentService(ServiceAssignmentService serviceAssignmentService) {
    this.serviceAssignmentService = serviceAssignmentService;
  }

  public ResponseEntity<ServiceAssignment> findServiceAssignment(@PathVariable Long id) {
    return serviceAssignmentService.getServiceAssignment(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<ServiceAssignment> findAllServiceAssignments() {
    return serviceAssignmentService.findAllServiceAssignments();
  }

  @ResponseStatus(HttpStatus.CREATED)
  public ServiceAssignment createServiceAssignment(
      @RequestBody ServiceAssignment serviceAssignment) {
    return serviceAssignmentService.addServiceAssignment(serviceAssignment);
  }

  public ResponseEntity<ServiceAssignment> updateServiceAssignment(@PathVariable Long id,
      @RequestBody ServiceAssignment serviceAssignment) {
    Optional<ServiceAssignment> serviceAssignmentOptional = serviceAssignmentService.updateServiceAssignment(
        id, serviceAssignment);
    return serviceAssignmentOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void deleteServiceAssignment(@PathVariable Long id) {
    serviceAssignmentService.deleteServiceAssignment(id);
  }
}
