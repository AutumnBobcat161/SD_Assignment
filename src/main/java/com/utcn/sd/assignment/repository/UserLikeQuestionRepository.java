package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.UserLikeQuestionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeQuestionRepository extends JpaRepository<UserLikeQuestionDto, Integer> {
}
