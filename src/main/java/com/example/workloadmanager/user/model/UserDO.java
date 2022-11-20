package com.example.workloadmanager.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDO {

  @Id
  @Column(name = "id")
  private long id;

  @NonNull
  @Column(name = "name")
  private String name;

  @Column(name = "key")
  private String key;

}
