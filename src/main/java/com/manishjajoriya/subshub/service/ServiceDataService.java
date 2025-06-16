package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.model.DataGenerator;
import com.manishjajoriya.subshub.model.ServiceModel;
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
  

  public void loadData() {
    List<ServiceModel> serviceData = DataGenerator.getSampleServices();
    serviceDataRepo.saveAll(serviceData);
  }

  public List<ServiceModel> getAllServices() {
    return serviceDataRepo.findAll();
  }

  public ServiceModel getServiceById(int id) {
    return serviceDataRepo.findById(id).orElse(null);
  }
}
