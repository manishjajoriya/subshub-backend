package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.config.CustomUserDetails;
import com.manishjajoriya.subshub.dto.UserDataDto;
import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.service.UserDataService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserDataService userDataService;

  @Autowired
  public UserController(UserDataService userDataService) {
    this.userDataService = userDataService;
  }

  @GetMapping("/my-data")
  public ResponseEntity<?> getUserData() {
    CustomUserDetails userDetails =
        (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    List<UserDataEntity> data = userDataService.getUserData(userDetails.getUid());
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

  @PostMapping("/add-new-service")
  public ResponseEntity<?> addNewService(@RequestBody UserDataDto userDataDto) {
    CustomUserDetails userDetails =
        (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return new ResponseEntity<>(userDataService.addNewService(userDataDto,
        userDetails.getUser()), HttpStatus.OK);
  }

  @DeleteMapping("/delete-service")
  public ResponseEntity<?> deleteService(@RequestParam UUID did) {
    CustomUserDetails customUserDetails =
        (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return ResponseEntity.ok(userDataService.deleteService(did, customUserDetails.getUid()));
  }
}
