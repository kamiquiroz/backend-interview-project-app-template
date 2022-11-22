package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.ServiceApi;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.service.ServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController implements ServiceApi {

  private ServiceService serviceService;

  @Autowired
  public void setServiceService(
      ServiceService serviceService) {
    this.serviceService = serviceService;
  }

  @Override
  public ResponseEntity<Service> findService(Long id) {
    return serviceService.getServiceById(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<Service> findAllServices() {
    return serviceService.getAllService();
  }

  @Override
  public Service createService(Service service) {
    return serviceService.addService(service);
  }

  @Override
  public ResponseEntity<Service> updateService(@PathVariable Long id,
      @RequestBody Service service) {
    Optional<Service> serviceOptional = serviceService.updateService(id, service);
    return serviceOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public void deleteService(Long id) {
    serviceService.deleteService(id);
  }
}
