package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.TechnologyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyTypeRepository extends JpaRepository<TechnologyTypeEntity, Long> {
}
