package com.manishjajoriya.subshub.model;

import lombok.Data;

/**
 * This Model is used to store user information.
 */
@Data
public class UserModel {
  private int uid;
  private String name;
  private String email;
  private String password;
  private String region;
}
