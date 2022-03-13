package com.utcn.sd.assignment.service.question;

import com.utcn.sd.assignment.mapper.QuestionTagMapper;
import com.utcn.sd.assignment.model.QuestionTag;
import com.utcn.sd.assignment.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionTagServiceImpl implements QuestionTagService {

    @Autowired
    private QuestionTagRepository questionTagRepository;

    @Override
    public QuestionTag getQuestionTagById(int id) {
        return QuestionTagMapper.toEntity(questionTagRepository.getById(id));
    }

    @Override
    public QuestionTag createQuestionTag(QuestionTag questionTag) {
        return QuestionTagMapper.toEntity(questionTagRepository.save(QuestionTagMapper.toDto(questionTag)));
    }

    @Override
    public List<QuestionTag> getAllQuestionTags() {
        return questionTagRepository.findAll()
                .stream()
                .map(QuestionTagMapper::toEntity)
                .collect(Collectors.toList());
    }
}
