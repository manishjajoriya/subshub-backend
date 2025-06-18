package com.manishjajoriya.subshub.repository;

import com.manishjajoriya.subshub.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDataRepo extends JpaRepository<ServiceEntity, Integer> {

}
