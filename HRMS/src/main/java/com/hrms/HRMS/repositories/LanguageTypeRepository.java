package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.LanguageTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTypeRepository extends JpaRepository<LanguageTypeEntity, Long> {
}
