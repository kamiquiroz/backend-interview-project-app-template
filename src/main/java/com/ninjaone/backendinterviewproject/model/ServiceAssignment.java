package com.ninjaone.backendinterviewproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "service_assignments")
public class ServiceAssignment {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  @JsonBackReference
  @Exclude
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_id")
  @JsonBackReference
  @Exclude
  private Service service;

  private Date date;

}
