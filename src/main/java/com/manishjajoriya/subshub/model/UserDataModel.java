package com.manishjajoriya.subshub.model;

import java.sql.Date;
import lombok.Data;

/**
 * This model is used to store user data like which service he is subscribed.
 */
@Data
public class UserDataModel {
  private int sid;
  private int uid;
  private String serviceProvider;
  private String servicePrice;
  private String category;
  private String currency;
  private Date startBillingDate;
  private Date nextBillingDate;
  private int months;
  private boolean isActive;
  private boolean isDeleted;
  private boolean isCanceled;
}
