package com.example.workloadmanager.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDO {

  @Id
  @Column(name = "id")
  private long id;

  @NonNull
  @Column(name = "name")
  private String name;

  @Column(name = "creation_date")
  private LocalDateTime creationDate;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserDO user;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "stock_volume")
  private String stockVolume;

}
