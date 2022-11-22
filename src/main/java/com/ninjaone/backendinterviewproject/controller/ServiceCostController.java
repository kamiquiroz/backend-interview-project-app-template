package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.ServiceCostApi;
import com.ninjaone.backendinterviewproject.model.ServiceCost;
import com.ninjaone.backendinterviewproject.service.ServiceCostService;
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
public class ServiceCostController implements ServiceCostApi {

  private ServiceCostService serviceCostService;

  @Autowired
  public void setServiceCostService(ServiceCostService serviceCostService) {
    this.serviceCostService = serviceCostService;
  }

  public ResponseEntity<ServiceCost> findServiceCost(@PathVariable Long id) {
    return serviceCostService.getServiceCostById(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<ServiceCost> findAllServiceCosts() {
    return serviceCostService.getAllServiceCost();
  }

  @ResponseStatus(HttpStatus.CREATED)
  public ServiceCost createServiceCost(@RequestBody ServiceCost serviceCost) {
    return serviceCostService.addServiceCost(serviceCost);
  }

  public ResponseEntity<ServiceCost> updateServiceCost(@PathVariable Long id, @RequestBody ServiceCost serviceCost) {
    Optional<ServiceCost> serviceCostOptional = serviceCostService.updateServiceCost(id, serviceCost);
    return serviceCostOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void deleteServiceCost(@PathVariable Long id) {
    serviceCostService.deleteServiceCost(id);
  }
}
