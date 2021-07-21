package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {
}
