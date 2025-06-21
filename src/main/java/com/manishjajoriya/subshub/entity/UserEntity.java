package com.manishjajoriya.subshub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  @NotNull(message = "email is mandatory")
  @NotBlank
  @Email(message = "enter correct email")
  private String email;
  @NotNull
  @NotBlank
  private String password;
  private List<String> role = List.of("USER");
  private String region;
}
