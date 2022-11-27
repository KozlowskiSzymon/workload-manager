package com.example.workloadmanager.user.control;

import com.example.workloadmanager.task.model.TaskDO;
import com.example.workloadmanager.user.model.UserDO;

import java.util.List;

public interface UserService {
  UserDO getUserData(long userId);

  List<TaskDO> getUserTasks(long userId);

  TaskDO createTaskForUser(long userId);
}
