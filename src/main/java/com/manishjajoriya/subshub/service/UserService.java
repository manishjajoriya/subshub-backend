package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  public ResponseEntity<?> signUp(UserEntity user) {
    if (userRepo.findByEmail(user.getEmail()).isPresent()) {
      return new ResponseEntity<>("User already exist, try to login in.", HttpStatus.CONFLICT);
    } else {
      String encodedPassword = passwordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      userRepo.save(user);
      return  new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
    }
  }
}
