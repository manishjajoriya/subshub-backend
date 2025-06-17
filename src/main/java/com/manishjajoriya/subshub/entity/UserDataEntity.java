package com.manishjajoriya.subshub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
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
  private int sid;
  private int uid;
  private String serviceProvider;
  private String servicePrice;
  private String category;
  private String currency;
  private Date startBillingDate;
  private Date nextBillingDate;
  private int months;
  private boolean isActive = true;
  private boolean isDeleted = false;
  private boolean isCanceled = false;
}
