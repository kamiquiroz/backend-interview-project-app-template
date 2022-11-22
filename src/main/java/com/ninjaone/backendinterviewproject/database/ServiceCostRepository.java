package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCostRepository extends CrudRepository<ServiceCost, Long> {
  @Query(value = "SELECT SUM(sc.cost) FROM ServiceCost AS sc "
      + " INNER JOIN Service AS s ON sc.service = s"
      + " INNER JOIN ServiceAssignment AS sa ON sa.service = s"
      + " INNER JOIN Device AS d ON sa.device = d "
      + " INNER JOIN Type AS t ON sc.type = t "
      + " WHERE d.id = ?1 AND t.typeName = ?2 "
      + " AND sa.date > DATEADD('MONTH', -1, CURRENT_DATE())")
  Double getAllServiceCostByDevice(Long deviceId, String typeName);

}
