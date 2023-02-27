package com.example.workloadmanager.prime;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PrimeConfig {

  @Value("${app.connection.prime.url}")
  private String basicUrl;
  @Value("${app.connection.prime.random-path:/api/prime/random}")
  private String randomPath;
}
