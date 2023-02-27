package com.example.workloadmanager.cypher;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CypherESI {

  private final CypherConfig config;
  private final WebClient client;

  public CypherESI(CypherConfig config) {
    this.config = config;
    this.client = WebClient.builder().baseUrl(config.getBasicUrl()).build();
  }

  public String encrypt(CypherDTO dto) {
    return client.post()
        .uri(config.getBasicUrl() + config.getEncryptPath())
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }

  public String decrypt(CypherDTO dto) {
    return client.post()
        .uri(config.getBasicUrl() + config.getDecryptPath())
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }

  public String generateKey(long userId) {
    return client.post()
        .uri(config.getBasicUrl() + config.getKeysPath())
        .body(BodyInserters.fromValue(userId))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }
}
