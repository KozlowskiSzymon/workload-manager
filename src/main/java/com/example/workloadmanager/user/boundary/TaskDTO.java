package com.example.workloadmanager.user.boundary;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {

  private long id;
  private String name;
  private LocalDateTime creationDate;
  private long userId;
  private String companyName;
  private String stockVolume;

}
