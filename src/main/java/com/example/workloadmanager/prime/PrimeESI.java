package com.example.workloadmanager.prime;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PrimeESI {

  private final PrimeConfig config;
  private final WebClient client;

  public PrimeESI(PrimeConfig config) {
    this.config = config;
    this.client = WebClient.builder().baseUrl(config.getBasicUrl()).build();
  }

  public long getRandomPrime() {
    var primeString = client.get()
        .uri(config.getBasicUrl() + config.getRandomPath())
        .retrieve()
        .bodyToMono(String.class)
        .block();
    if (primeString != null) {
      return Long.parseLong(primeString);
    } else {
      return 3;
    }
  }
}
