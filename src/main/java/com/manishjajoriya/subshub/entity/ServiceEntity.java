package com.manishjajoriya.subshub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This model is used for storing different service available in DB. and search copy of this is
 * sent to user when requested.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
  @Id
  public UUID sid;
  private String provider;
  private String description;
  private List<String> plans;
  private String category;
  private String iconUrl;
}
