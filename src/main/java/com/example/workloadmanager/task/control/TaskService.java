package com.example.workloadmanager.task.control;

import com.example.workloadmanager.task.model.TaskDO;

import java.util.List;

public interface TaskService {
  List<TaskDO> getByUserId(long userId);

  TaskDO save(TaskDO task);

    void cleanTasksTable();
}
