package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.service.SubscriptionService;
import com.manishjajoriya.subshub.service.UserDataService;
import com.manishjajoriya.subshub.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

  private final UserService userService;
  private final UserDataService userDataService;
  private final SubscriptionService subscriptionService;

  @Autowired
  public AdminController(UserService userService, UserDataService userDataService,
                         SubscriptionService subscriptionService) {
    this.userService = userService;
    this.userDataService = userDataService;
    this.subscriptionService = subscriptionService;
  }

  @GetMapping("/all-users")
  public ResponseEntity<?> getAllUsers() {
    List<UserEntity> users = userService.getAllUser();
    if (!users.isEmpty()) {
      return new ResponseEntity<>(users, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/all-user-data")
  public ResponseEntity<?> getAllUserData() {
    return new ResponseEntity<>(userDataService.getAllUserData(), HttpStatus.OK);
  }

  @GetMapping("/all-subscription")
  public ResponseEntity<?> getAllSubscriptions() {
    return new ResponseEntity<>(subscriptionService.getAllServices(), HttpStatus.OK);
  }

  @PostMapping("/add-admin-user")
  public ResponseEntity<?> addAdminUser(@RequestBody UserEntity user) {
    return userService.createNewAdmin(user);
  }
}
