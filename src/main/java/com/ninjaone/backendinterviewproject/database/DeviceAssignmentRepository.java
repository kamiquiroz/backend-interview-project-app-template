package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAssignmentRepository extends CrudRepository<DeviceAssignment, Long> {

}
