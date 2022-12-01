package com.example.workloadmanager.prime;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PrimeConfig {

  @Value("http://localhost:8081/api/prime")
  private String url;
}
