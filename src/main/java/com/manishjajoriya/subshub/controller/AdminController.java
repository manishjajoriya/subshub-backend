package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.entity.UserEntity;
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

  @Autowired
  public AdminController(UserService userService, UserDataService userDataService) {
    this.userService = userService;
    this.userDataService = userDataService;
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
    List<UserDataEntity> userData = userDataService.getAllUserData();
    if (!userData.isEmpty()) {
      return new ResponseEntity<>(userData, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/add-admin-user")
  public ResponseEntity<?> addAdminUser(@RequestBody UserEntity user) {
    return userService.createNewAdmin(user);
  }
}
