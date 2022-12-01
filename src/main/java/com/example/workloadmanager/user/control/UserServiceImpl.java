package com.example.workloadmanager.user.control;

import com.example.workloadmanager.cypher.CypherDTO;
import com.example.workloadmanager.cypher.CypherESI;
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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

  private final UserRepository userRepository;
  private final TaskService taskService;
  private final PrimeESI primeESI;
  private final CypherESI cypherESI;


  @Override
  public void initiateUsers() {
    var users = userRepository.findAll();
    Executor executor = Executors.newFixedThreadPool(10);
    users.forEach(user -> executor.execute(() -> generateKeyForUser(user)));
  }

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
    if (user.getKey() == null) {
      generateKeyForUser(user);
    }
    var task = TaskDO.builder()
        .name(prepareTaskNameForUser(user))
        .user(user)
        .creationDate(LocalDateTime.now())
        .companyName(getCompanyName(userId))
        .stockVolume(getStockVolume(userId))
        .build();
    return taskService.save(task);
  }

  private String getStockVolume(long userId) {
    var stockVolume = primeESI.getRandomPrime();
    var encryptRequest = CypherDTO.builder()
        .value(String.valueOf(stockVolume))
        .publicKey(getUserData(userId).getKey())
        .userId(userId)
        .build();
    return cypherESI.encrypt(encryptRequest);
  }

  private String getCompanyName(long userId) {
    var companyName = UUID.randomUUID() + "-" + primeESI.getRandomPrime();
    var encryptRequest = CypherDTO.builder()
        .value(companyName)
        .publicKey(getUserData(userId).getKey())
        .userId(userId)
        .build();
    return cypherESI.encrypt(encryptRequest);
  }

  private void generateKeyForUser(UserDO user) {
    log.info("[Manager] Generating public key for user with id: [{}]...", user.getId());
    var key = cypherESI.generateKey(user.getId());
    user.setKey(key);
    userRepository.save(user);
    log.info("[Manager] Saved key for user with id: [{}].", user.getId());
  }

  private String prepareTaskNameForUser(UserDO user) {
    return user.getName() + "-" + UUID.randomUUID();
  }

}
