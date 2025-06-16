package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.model.DataGenerator;
import com.manishjajoriya.subshub.model.UserDataModel;
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

  public List<UserDataModel> getUserData(int uid) {
    return userDataRepo.findAllByUid(uid);
  }

  public void loadData() {
    List<UserDataModel> userData = DataGenerator.getSampleUserData();
    userDataRepo.saveAll(userData);
  }
}
