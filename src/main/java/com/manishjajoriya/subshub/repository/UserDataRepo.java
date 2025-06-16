package com.manishjajoriya.subshub.repository;

import com.manishjajoriya.subshub.model.UserDataModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends JpaRepository<UserDataModel, Integer> {
  List<UserDataModel> findAllByUid(int uid);
}
