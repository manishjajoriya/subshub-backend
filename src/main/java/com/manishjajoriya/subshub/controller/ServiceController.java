package com.manishjajoriya.subshub.controller;

import com.manishjajoriya.subshub.model.ServiceModel;
import com.manishjajoriya.subshub.model.UserDataModel;
import com.manishjajoriya.subshub.service.ServiceDataService;
import com.manishjajoriya.subshub.service.UserDataService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @PutMapping("/load-data")
  @Transactional
  public String loadData() {
    serviceDataService.loadData();
    userDataService.loadData();
    return "Data loaded Successfully";
  }

  @GetMapping("services")
  public List<ServiceModel> getServiceData() {
    return serviceDataService.getAllServices();
  }

  @GetMapping("/service/{id}")
  public ServiceModel getServiceData(@PathVariable int id) {
    return serviceDataService.getServiceById(id);
  }

  @GetMapping("/user")
  public List<UserDataModel> getUserData(@RequestParam int uid) {
    return userDataService.getUserData(uid);
  }
}
