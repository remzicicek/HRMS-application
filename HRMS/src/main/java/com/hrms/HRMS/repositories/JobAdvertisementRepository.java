package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.JobAdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisementEntity, Long> {
}
