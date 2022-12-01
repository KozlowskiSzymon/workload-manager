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
    this.client = WebClient.builder().baseUrl(config.getUrl()).build();
  }

  public String encrypt(CypherDTO dto) {
    return client.post()
        .uri(config.getUrl() + "/encrypt")
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }
  public String decrypt(CypherDTO dto) {
    return client.post()
        .uri(config.getUrl() + "/decrypt")
        .body(BodyInserters.fromValue(dto))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }
  public String generateKey(long userId) {
    return client.get()
        .uri(uriBuilder -> uriBuilder.path("/keys").queryParam("userId", userId).build())
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }
}
