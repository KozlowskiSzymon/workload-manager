package com.example.workloadmanager.cypher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class CypherESI {

  private final CypherConfig config;
  private final WebClient client;

  public CypherESI(CypherConfig config) {
    this.config = config;
    this.client = WebClient.builder().baseUrl(config.getBasicUrl()).build();
  }

  public String encrypt(CypherDTO dto) {
    log.info("CypherESI.encrypt POST " + config.getBasicUrl() + config.getEncryptPath());
    return client.post()
        .uri(config.getBasicUrl() + config.getEncryptPath())
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }

  public String decrypt(CypherDTO dto) {
    log.info("CypherESI.decrypt POST " + config.getBasicUrl() + config.getDecryptPath());
    return client.post()
        .uri(config.getBasicUrl() + config.getDecryptPath())
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }

  public CypherDTO generateKey(long userId) {
    log.info("CypherESI.generateKey POST " + config.getBasicUrl() + config.getKeysPath());
    return client.post()
        .uri(config.getBasicUrl() + config.getKeysPath())
        .body(BodyInserters.fromValue(userId))
        .retrieve()
        .bodyToMono(CypherDTO.class)
        .block();
  }
}
