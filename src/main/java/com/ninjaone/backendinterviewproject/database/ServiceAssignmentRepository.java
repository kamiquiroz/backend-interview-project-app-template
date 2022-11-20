package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.ServiceAssignment;
import org.springframework.data.repository.CrudRepository;

public interface ServiceAssignmentRepository extends CrudRepository<ServiceAssignment, Long> {

}
