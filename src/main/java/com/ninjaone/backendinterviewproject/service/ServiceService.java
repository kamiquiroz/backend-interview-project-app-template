package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Service;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public interface ServiceService {

  Optional<Service> getServiceById(Long id);

  Service addService(Service service);

  Optional<Service> updateService(Long id, Service service);

  void deleteService(Long id);

  List<Service> getAllService();
}
