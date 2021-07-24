package com.hrms.HRMS.repositories;

import com.hrms.HRMS.entities.concretes.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity, Long> {
}
