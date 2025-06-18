package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.DataGenerator;
import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.repository.UserDataRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
  private final UserDataRepo userDataRepo;

  @Autowired
  public UserDataService(UserDataRepo userDataRepo) {
    this.userDataRepo = userDataRepo;
  }

  public List<UserDataEntity> getUserData(int uid) {
    return userDataRepo.findAllByUid(uid);
  }

  public void loadData() {
    List<UserDataEntity> userData = DataGenerator.getSampleUserData();
    userDataRepo.saveAll(userData);
  }
}
