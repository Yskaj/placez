package com.sights.repository;

import com.sights.entity.SimpleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleAnswerRepository extends JpaRepository<SimpleAnswer,Long> {
}
