package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Device;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

  @Query(value =
      "SELECT d FROM Device AS d "
          + "INNER JOIN DeviceAssignment AS da ON da.device = d "
          + "INNER JOIN Customer AS c ON da.customer = c WHERE c.id = ?1")
  List<Device> getCustomerDevices(Long id);
}
