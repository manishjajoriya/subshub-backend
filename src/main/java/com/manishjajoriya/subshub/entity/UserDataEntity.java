package com.manishjajoriya.subshub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This model is used to store user data like which service he is subscribed.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataEntity {
  @Id
  private UUID did;
  @JsonIgnore
  @ManyToOne()
  private UserEntity user;
  private String subscriptionProvider;
  private String subscriptionPrice;
  private String category;
  private String currency;
  private String iconUrl;
  private LocalDateTime startBillingDate;
  private LocalDateTime nextBillingDate;
  private int months;
  private boolean isActive = true;
  private boolean isDeleted = false;
  private boolean isCanceled = false;
  private LocalDateTime timeStamp =  LocalDateTime.now();
}
