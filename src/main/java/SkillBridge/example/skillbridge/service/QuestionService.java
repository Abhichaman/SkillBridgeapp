package SkillBridge.example.skillbridge.service;

import SkillBridge.example.skillbridge.entity.QuizQuestion;
import SkillBridge.example.skillbridge.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;


    public List<QuizQuestion> getQuestionsBySubject(String subject){
        return questionRepo.findBySubject(subject);
    }


    public QuizQuestion saveQuestion(QuizQuestion question){
        QuizQuestion save = questionRepo.save(question);
        return save;
    }
}
