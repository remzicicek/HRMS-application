package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
}
