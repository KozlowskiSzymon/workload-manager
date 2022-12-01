package com.example.workloadmanager.task.control;

import com.example.workloadmanager.task.model.TaskDO;
import com.example.workloadmanager.task.model.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

  private final TaskRepository taskRepository;

  @Override
  public List<TaskDO> getByUserId(long userId) {
    return taskRepository.findByUserId(userId);
  }

  @Override
  public TaskDO save(TaskDO task) {
    return taskRepository.save(task);
  }
}
