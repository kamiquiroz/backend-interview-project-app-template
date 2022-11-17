package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceDeviceServiceImpl implements ServiceDeviceService {

  private ServiceDeviceRepository serviceDeviceRepository;

  @Autowired
  public void setServiceRepository(ServiceDeviceRepository serviceDeviceRepository) {
    this.serviceDeviceRepository = serviceDeviceRepository;
  }

  @Override
  public Optional<ServiceDevice> getServiceById(Long id) {
    return serviceDeviceRepository.findById(id);
  }

  @Override
  public ServiceDevice addService(ServiceDevice service) {
    return serviceDeviceRepository.save(service);
  }

  @Override
  public Optional<ServiceDevice> updateService(Long id, ServiceDevice serviceDevice) {
    Optional<ServiceDevice> currentSolutionOptional = serviceDeviceRepository.findById(id);
    if (currentSolutionOptional.isPresent()) {
      ServiceDevice currentServiceDevice = currentSolutionOptional.get();
      currentServiceDevice.setSystemName(serviceDevice.getSystemName());
      return Optional.of(serviceDeviceRepository.save(currentServiceDevice));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteService(Long id) {
    serviceDeviceRepository.deleteById(id);
  }
}
