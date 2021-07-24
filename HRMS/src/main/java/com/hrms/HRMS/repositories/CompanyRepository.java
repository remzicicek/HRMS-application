package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
