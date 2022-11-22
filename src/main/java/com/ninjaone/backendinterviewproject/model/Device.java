package com.ninjaone.backendinterviewproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "devices")
public class Device {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String systemName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "type_id")
  @JsonBackReference
  @Exclude
  private Type type;

  private Double cost;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
  @JsonManagedReference
  @Exclude
  private List<ServiceAssignment> serviceAssignments;
}
