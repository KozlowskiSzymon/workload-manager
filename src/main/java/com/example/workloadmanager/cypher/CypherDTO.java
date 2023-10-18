package com.example.workloadmanager.cypher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CypherDTO {

  public CypherDTO() {
  }

  public CypherDTO(String value, String publicKey, String privateKey, long userId) {
    this.value = value;
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    this.userId = userId;
  }

  @JsonProperty("value")
  private String value;
  @JsonProperty("publicKey")
  private String publicKey;
  @JsonProperty("privateKey")
  private String privateKey;
  @JsonProperty("userId")
  private long userId;

  public void setValue(String value) {
    this.value = value;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getValue() {
    return value;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public long getUserId() {
    return userId;
  }
}
