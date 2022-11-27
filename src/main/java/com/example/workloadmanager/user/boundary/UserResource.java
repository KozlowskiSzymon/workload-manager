package com.example.workloadmanager.user.boundary;

import com.example.workloadmanager.task.boundary.TaskDTO;
import com.example.workloadmanager.task.control.TaskAssembler;
import com.example.workloadmanager.user.control.UserAssembler;
import com.example.workloadmanager.user.control.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserResource {

  private UserService userService;

  private UserAssembler userAssembler;

  private TaskAssembler taskAssembler;

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getUserData(@PathVariable("userId") long userId) {
    return ok(userAssembler.toDTO(userService.getUserData(userId)));
  }

  @GetMapping("/{userId}/tasks")
  public ResponseEntity<List<TaskDTO>> getUserTasks(@PathVariable("userId") long userId) {
    return ok(taskAssembler.toDTO(userService.getUserTasks(userId)));
  }

  @PostMapping("/{userId}/task/create")
  public ResponseEntity<TaskDTO> createTaskForUser(@PathVariable("userId") long userId) {
    return ok(taskAssembler.toDTO(userService.createTaskForUser(userId)));
  }
}
