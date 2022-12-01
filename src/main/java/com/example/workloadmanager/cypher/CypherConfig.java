package com.example.workloadmanager.cypher;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CypherConfig {

  @Value("http://localhost:8082/api/cypher")
  private String url;
}
