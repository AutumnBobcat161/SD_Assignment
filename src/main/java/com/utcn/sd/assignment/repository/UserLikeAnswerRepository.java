package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.UserLikeAnswerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeAnswerRepository extends JpaRepository<UserLikeAnswerDto, Integer> {
}
