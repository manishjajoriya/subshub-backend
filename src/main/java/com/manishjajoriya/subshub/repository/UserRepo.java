package com.manishjajoriya.subshub.repository;

import com.manishjajoriya.subshub.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
  Optional<UserEntity> findByEmail(String email);

  Optional<UserEntity> findByUid(UUID uid);
}
