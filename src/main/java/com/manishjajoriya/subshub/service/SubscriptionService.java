package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.SubscriptionEntity;
import com.manishjajoriya.subshub.repository.SubscriptionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

  private final SubscriptionRepo subscriptionRepo;

  @Autowired
  public SubscriptionService(SubscriptionRepo subscriptionRepo) {
    this.subscriptionRepo = subscriptionRepo;
  }


  public List<SubscriptionEntity> searchByName(String name) {
    return subscriptionRepo.findByProviderContainingIgnoreCase(name);
  }

  public List<SubscriptionEntity> getAllServices() {
    return subscriptionRepo.findAll();
  }
}
