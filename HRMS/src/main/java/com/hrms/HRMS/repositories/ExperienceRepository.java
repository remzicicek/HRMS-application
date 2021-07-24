package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {
}
