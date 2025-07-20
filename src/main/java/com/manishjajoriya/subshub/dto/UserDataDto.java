package com.manishjajoriya.subshub.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {
  private String subscriptionProvider;
  private String subscriptionPrice;
  private String category;
  private String currency;
  private String iconUrl;
  private LocalDateTime startBillingDate;
  private LocalDateTime nextBillingDate;
  private int months;
}
