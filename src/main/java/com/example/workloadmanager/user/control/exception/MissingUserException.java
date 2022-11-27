package com.example.workloadmanager.user.control.exception;

public class MissingUserException extends RuntimeException{

  public MissingUserException(long userId) {
    super("User with id:[" + userId + "] does not exist.");
  }
}
