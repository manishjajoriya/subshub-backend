package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.entity.ServiceEntity;
import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.service.CustomUserDetails;
import com.manishjajoriya.subshub.service.ServiceDataService;
import com.manishjajoriya.subshub.service.UserDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

  private final ServiceDataService serviceDataService;
  private final UserDataService userDataService;

  @Autowired
  public ServiceController(ServiceDataService serviceDataService, UserDataService userDataService) {
    this.serviceDataService = serviceDataService;
    this.userDataService = userDataService;
  }

  @GetMapping("services")
  public List<ServiceEntity> getServiceData() {
    return serviceDataService.getAllServices();
  }

  @GetMapping("/service/{id}")
  public ServiceEntity getServiceData(@PathVariable int id) {
    return serviceDataService.getServiceById(id);
  }

  @GetMapping("/user")
  public List<UserDataEntity> getUserData() {
    CustomUserDetails userDetails =
        (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userDataService.getUserData(userDetails.getUid());
  }
}
