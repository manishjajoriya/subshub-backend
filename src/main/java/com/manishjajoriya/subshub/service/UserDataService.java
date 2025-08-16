package com.manishjajoriya.subshub.service;

import com.manishjajoriya.subshub.config.CustomUserDetails;
import com.manishjajoriya.subshub.dto.UserDataDto;
import com.manishjajoriya.subshub.entity.UserDataEntity;
import com.manishjajoriya.subshub.entity.UserEntity;
import com.manishjajoriya.subshub.repository.UserDataRepo;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDataService {
  private final UserDataRepo userDataRepo;
  private final ModelMapper modelMapper;

  @Autowired
  public UserDataService(UserDataRepo userDataRepo, ModelMapper modelMapper) {
    this.userDataRepo = userDataRepo;
    this.modelMapper = modelMapper;
  }

  public List<UserDataEntity> getUserData(UUID uid) {
    return userDataRepo.findByUserUid(uid);
  }

  public List<UserDataEntity> getAllUserData() {
    return userDataRepo.findAll();
  }

  public UserDataEntity addNewService(UserDataDto userDataDto, UserEntity userEntity) {

    UserDataEntity userDataEntity = modelMapper.map(userDataDto, UserDataEntity.class);
    userDataEntity.setDid(UUID.randomUUID());
    userDataEntity.setUser(userEntity);
    userDataRepo.save(userDataEntity);
    return userDataEntity;
  }

  @Transactional
  public ResponseEntity<?> deleteService(UUID did, UUID uid) {
    if (userDataRepo.existsByDidAndUser_Uid(did, uid)) {
      userDataRepo.deleteByDidAndUser_Uid(did, uid);
      return new ResponseEntity<>("service deleted", HttpStatus.OK);
    }
    return new ResponseEntity<>("service not found", HttpStatus.NOT_FOUND);
  }

  public LocalDateTime lastUpdate(CustomUserDetails userDetails) {
    UserDataEntity userdata =
        userDataRepo.findTopByUser_UidOrderByTimeStampDesc(userDetails.getUid());
    return userdata.getTimeStamp();
  }
}
