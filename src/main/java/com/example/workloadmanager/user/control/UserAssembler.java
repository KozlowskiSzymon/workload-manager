package com.example.workloadmanager.user.control;

import com.example.workloadmanager.user.boundary.UserDTO;
import com.example.workloadmanager.user.model.UserDO;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

  public UserDTO toDTO(UserDO userDO) {
    return UserDTO.builder()
        .id(userDO.getId())
        .name(userDO.getName())
        .key(userDO.getKey())
        .build();
  }
}
