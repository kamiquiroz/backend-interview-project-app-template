package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceAssignmentRepository;
import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAssignmentServiceImpl implements ServiceAssignmentService {

  private ServiceAssignmentRepository serviceAssignmentRepository;

  @Autowired
  public void setServiceAssignmentRepository(
      ServiceAssignmentRepository serviceAssignmentRepository) {
    this.serviceAssignmentRepository = serviceAssignmentRepository;
  }

  @Override
  public Optional<ServiceAssignment> getServiceAssignment(Long id) {
    return serviceAssignmentRepository.findById(id);
  }

  @Override
  public ServiceAssignment addServiceAssignment(ServiceAssignment serviceAssignment) {
    return serviceAssignmentRepository.save(serviceAssignment);
  }

  @Override
  public Optional<ServiceAssignment> updateServiceAssignment(Long id,
      ServiceAssignment serviceAssignment) {
    Optional<ServiceAssignment> currentServiceAssignmentOptional = serviceAssignmentRepository.findById(
        id);
    if (currentServiceAssignmentOptional.isPresent()) {
      ServiceAssignment currentServiceAssignment = currentServiceAssignmentOptional.get();
      currentServiceAssignment.setService(serviceAssignment.getService());
      currentServiceAssignment.setDevice(serviceAssignment.getDevice());
      currentServiceAssignment.setDate(serviceAssignment.getDate());
      return Optional.of(serviceAssignmentRepository.save(currentServiceAssignment));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteServiceAssignment(Long id) {
    serviceAssignmentRepository.deleteById(id);
  }

  @Override
  public List<ServiceAssignment> findAllServiceAssignments() {
    return (List<ServiceAssignment>) serviceAssignmentRepository.findAll();
  }
}
