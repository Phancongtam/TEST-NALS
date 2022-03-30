package com.demo.demospring.repository;

import com.demo.demospring.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
}
