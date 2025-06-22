package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class SubscriptionController {

  private final SubscriptionService subscriptionService;

  public SubscriptionController(SubscriptionService subscriptionService) {
    this.subscriptionService = subscriptionService;
  }

  @GetMapping("/search")
  public ResponseEntity<?> search(@RequestParam("name") String name) {
    return new ResponseEntity<>(subscriptionService.searchByName(name), HttpStatus.OK);
  }
}
