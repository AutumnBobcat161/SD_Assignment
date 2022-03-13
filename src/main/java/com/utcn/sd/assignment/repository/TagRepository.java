package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.TagDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagDto, Integer> {
}
