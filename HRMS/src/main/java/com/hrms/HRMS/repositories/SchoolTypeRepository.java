package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.SchoolTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolTypeEntity, Long> {
}
