package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public interface ServiceDeviceService {

  Optional<ServiceDevice> getServiceById(Long id);

  ServiceDevice addService(ServiceDevice service);

  Optional<ServiceDevice> updateService(Long id, ServiceDevice service);

  void deleteService(Long id);

}
