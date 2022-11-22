package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {

}
