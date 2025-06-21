package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.ServiceEntity;
import com.manishjajoriya.subshub.repository.ServiceDataRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDataService {
  private final ServiceDataRepo serviceDataRepo;
  
  @Autowired
  public ServiceDataService(ServiceDataRepo serviceDataRepo) {
    this.serviceDataRepo = serviceDataRepo;
  }

  public List<ServiceEntity> getAllServices() {
    return serviceDataRepo.findAll();
  }

  public ServiceEntity getServiceById(int id) {
    return serviceDataRepo.findById(id).orElse(null);
  }
}
