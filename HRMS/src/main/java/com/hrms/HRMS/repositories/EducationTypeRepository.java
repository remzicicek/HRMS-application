package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.EducationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationTypeEntity, Long> {
}
