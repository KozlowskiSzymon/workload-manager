package com.example.workloadmanager.user.boundary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

  private long id;
  private String name;
  private String key;
  private String privateKey;

}
