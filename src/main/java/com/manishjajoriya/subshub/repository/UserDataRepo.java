package com.manishjajoriya.subshub.repository;

import com.manishjajoriya.subshub.entity.UserDataEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("checkstyle:MethodName")
public interface UserDataRepo extends JpaRepository<UserDataEntity, UUID> {
  List<UserDataEntity> findByUserUid(UUID userUid);

  void deleteByDidAndUser_Uid(UUID did, UUID userUid);

  boolean existsByDidAndUser_Uid(UUID did, UUID userUid);

  UserDataEntity findTopByUser_UidOrderByTimeStamp(UUID userUid);
}
