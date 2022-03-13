package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.QuestionTagDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTagRepository extends JpaRepository<QuestionTagDto, Integer> {
}
