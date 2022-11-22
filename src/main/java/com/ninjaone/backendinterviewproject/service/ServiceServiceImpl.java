package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceRepository;
import com.ninjaone.backendinterviewproject.model.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

  private ServiceRepository serviceRepository;

  @Autowired
  public void setServiceRepository(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  @Override
  public Optional<Service> getServiceById(Long id) {
    return serviceRepository.findById(id);
  }

  @Override
  public Service addService(Service service) {
    return serviceRepository.save(service);
  }

  @Override
  public Optional<Service> updateService(Long id, Service service) {
    Optional<Service> currentSolutionOptional = serviceRepository.findById(id);
    if (currentSolutionOptional.isPresent()) {
      Service currentService = currentSolutionOptional.get();
      currentService.setServiceName(service.getServiceName());
      return Optional.of(serviceRepository.save(currentService));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteService(Long id) {
    serviceRepository.deleteById(id);
  }

  @Override
  public List<Service> getAllService() {
    return (List<Service>) serviceRepository.findAll();
  }
}
