package com.example.workloadmanager.user.control;

import com.example.workloadmanager.user.boundary.TaskDTO;
import com.example.workloadmanager.user.model.TaskDO;

import java.util.List;

public class TaskAssembler {

  public List<TaskDTO> toDTO(List<TaskDO> taskDOs) {
    return taskDOs.stream().map(this::toDTO).toList();
  }

  public TaskDTO toDTO(TaskDO taskDO) {
    return TaskDTO.builder()
        .id(taskDO.getId())
        .name(taskDO.getName())
        .creationDate(taskDO.getCreationDate())
        .userId(taskDO.getUser().getId())
        .companyName(taskDO.getCompanyName())
        .stockVolume(taskDO.getStockVolume())
        .build();
  }
}
