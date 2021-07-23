package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
