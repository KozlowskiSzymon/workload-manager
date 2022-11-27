package com.example.workloadmanager.user.control;

import com.example.workloadmanager.prime.PrimeESI;
import com.example.workloadmanager.task.control.TaskService;
import com.example.workloadmanager.task.model.TaskDO;
import com.example.workloadmanager.user.control.exception.MissingUserException;
import com.example.workloadmanager.user.model.UserDO;
import com.example.workloadmanager.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

  private UserRepository userRepository;
  private TaskService taskService;

  private PrimeESI primeESI;


  @Override
  public UserDO getUserData(long userId) {
    return userRepository.findById(userId).orElseThrow(() -> new MissingUserException(userId));
  }

  @Override
  public List<TaskDO> getUserTasks(long userId) {
    return taskService.getByUserId(userId);
  }

  @Override
  public TaskDO createTaskForUser(long userId) {
    var user = getUserData(userId);
    var task = TaskDO.builder()
        .name(prepareTaskNameForUser(user))
        .user(user)
        .creationDate(LocalDateTime.now())
        .companyName(getCompanyName())
        .stockVolume(getStockVolume())
        .build();
    return taskService.save(task);
  }

  private String getStockVolume() {
    return null;
  }

  private String getCompanyName() {
    return null;
  }

  private String prepareTaskNameForUser(UserDO user) {
    return user.getName() + "-" + UUID.randomUUID();
  }

}
