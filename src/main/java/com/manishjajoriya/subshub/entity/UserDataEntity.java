package com.manishjajoriya.subshub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
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
  private UUID sid;
  private UUID uid;
  private String subscriptionProvider;
  private String subscriptionPrice;
  private String category;
  private String currency;
  private String iconUrl;
  private Date startBillingDate;
  private Date nextBillingDate;
  private int months;
  private boolean isActive = true;
  private boolean isDeleted = false;
  private boolean isCanceled = false;
}
