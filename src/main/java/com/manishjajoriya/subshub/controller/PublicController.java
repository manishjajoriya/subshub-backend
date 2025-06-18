package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.service.ServiceDataService;
import com.manishjajoriya.subshub.service.UserDataService;
import com.manishjajoriya.subshub.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {

  private final UserService userService;
  private final UserDataService userDataService;
  private final ServiceDataService serviceDataService;

  @Autowired
  PublicController(UserService userService, UserDataService userDataService,
                   ServiceDataService serviceDataService) {
    this.userService = userService;
    this.userDataService = userDataService;
    this.serviceDataService = serviceDataService;
  }

  @GetMapping("/health-check")
  public String healthCheck() {
    log.info("OK");
    return "health-check : OK";
  }

  @PutMapping("/load-data")
  @Transactional
  public String loadData() {
    serviceDataService.loadData();
    userDataService.loadData();
    return "Data loaded Successfully";
  }

  @PostMapping("/sign-up")
  public ResponseEntity<?> signUp(@RequestBody UserEntity user) {
    log.info("Register User");
    return userService.signUp(user);
  }
}
