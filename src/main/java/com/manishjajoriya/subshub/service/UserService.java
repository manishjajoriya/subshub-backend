package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

  public boolean signUp(UserEntity user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    userRepo.save(user);
    return true;
  }
}
