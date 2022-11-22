package com.ninjaone.backendinterviewproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class Service {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String serviceName;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
  @JsonManagedReference
  @Exclude
  private List<ServiceCost> serviceCosts;

}
