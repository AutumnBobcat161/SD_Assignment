package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.AnswerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerDto, Integer> {
}
