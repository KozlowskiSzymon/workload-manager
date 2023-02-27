package com.example.workloadmanager.cypher;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CypherConfig {

  @Value("${app.connection.cypher.url}")
  private String basicUrl;

  @Value("${app.connection.cypher.encrypt-path:/api/cypher/encrypt}")
  private String encryptPath;

  @Value("${app.connection.cypher.decrypt-path:/api/cypher/decrypt}")
  private String decryptPath;

  @Value("${app.connection.cypher.keys-path:/api/cypher/keys}")
  private String keysPath;
}
