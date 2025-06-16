package com.manishjajoriya.subshub.model;

import java.util.List;


/**
 * This model is used for storing different service available in DB. and search copy of this is
 * sent to user when requested.
 */
public class ServiceModel {
  private String provider;
  private String description;
  private List<String> plans;
  private String category;
}
