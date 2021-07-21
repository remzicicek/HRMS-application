package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
}
