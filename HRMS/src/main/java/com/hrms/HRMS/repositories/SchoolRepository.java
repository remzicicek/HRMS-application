package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {
}
