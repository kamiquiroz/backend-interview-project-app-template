package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ServiceAssignmentService {

  Optional<ServiceAssignment> getServiceAssignment(Long id);

  ServiceAssignment addServiceAssignment(ServiceAssignment serviceAssignment);

  Optional<ServiceAssignment> updateServiceAssignment(Long id, ServiceAssignment serviceAssignment);

  void deleteServiceAssignment(Long id);

}
