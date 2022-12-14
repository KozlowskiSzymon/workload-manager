package com.example.workloadmanager.task.control;

import com.example.workloadmanager.task.boundary.TaskDTO;
import com.example.workloadmanager.task.model.TaskDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
