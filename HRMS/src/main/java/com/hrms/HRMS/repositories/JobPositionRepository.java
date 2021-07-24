package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.JobPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPositionEntity, Long> {
}
