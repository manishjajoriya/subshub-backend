package com.manishjajoriya.subshub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This Model is used to store user information.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  private UUID uid;
  private String name;
  @Column(unique = true)
  private String email;
  private String password;
  private List<String> role = List.of("USER");
  private String region = "india";
}
