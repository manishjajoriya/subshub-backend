package com.manishjajoriya.subshub.repository;

import com.manishjajoriya.subshub.entity.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesDataRepo extends JpaRepository<ServicesEntity, Integer> {

}
