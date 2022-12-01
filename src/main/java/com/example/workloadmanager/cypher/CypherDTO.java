package com.example.workloadmanager.cypher;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CypherDTO {

  private String value;
  private String publicKey;
  private long userId;

}
