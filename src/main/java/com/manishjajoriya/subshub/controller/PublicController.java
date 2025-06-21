package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.service.CustomUserDetails;
import com.manishjajoriya.subshub.service.ServiceDataService;
import com.manishjajoriya.subshub.service.UserDataService;
import com.manishjajoriya.subshub.service.UserService;
import com.manishjajoriya.subshub.utils.JwtUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.security.core.Authentication;
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
  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;
  private final CompromisedPasswordChecker compromisedPasswordChecker;

  @Autowired
  PublicController(UserService userService,
                   UserDataService userDataService,
                   ServiceDataService serviceDataService,
                   AuthenticationManager authenticationManager,
                   JwtUtil jwtUtil,
                   CompromisedPasswordChecker compromisedPasswordChecker) {
    this.userService = userService;
    this.userDataService = userDataService;
    this.serviceDataService = serviceDataService;
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
    this.compromisedPasswordChecker = compromisedPasswordChecker;
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
  public ResponseEntity<?> signUp(@Valid @RequestBody UserEntity user) {
    log.info("Register User");
    CompromisedPasswordDecision decision = compromisedPasswordChecker.check(user.getPassword());
    if (decision.isCompromised()) {
      throw new CompromisedPasswordException("This provided password is compromised and cannot "
          + "be used.");
    }
    return userService.signUp(user);

  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody UserEntity user) {
    try {
      Authentication auth = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

      CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
      String uuid = customUserDetails.getUid().toString();
      String jwt = jwtUtil.generateToken(uuid);
      return ResponseEntity.ok(jwt);
    } catch (Exception e) {
      log.error("Exception occur while createAuthenticationToken ", e);
      return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
    }
  }
}
