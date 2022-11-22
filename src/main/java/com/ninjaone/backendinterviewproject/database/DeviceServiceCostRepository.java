package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.DeviceServiceCost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceServiceCostRepository extends CrudRepository<DeviceServiceCost, Long> {

}
