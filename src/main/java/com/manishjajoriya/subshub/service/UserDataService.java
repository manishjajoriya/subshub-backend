package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.repository.UserDataRepo;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
  private final UserDataRepo userDataRepo;

  @Autowired
  public UserDataService(UserDataRepo userDataRepo) {
    this.userDataRepo = userDataRepo;
  }

  public List<UserDataEntity> getUserData(UUID uid) {
    return userDataRepo.findByUser_Uid(uid);
  }

  public List<UserDataEntity> getAllUserData() {
    return userDataRepo.findAll();
  }
}
