package SkillBridge.example.skillbridge.repo;

import SkillBridge.example.skillbridge.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion, Long> {
    List<QuizQuestion> findBySubject(String subject);
}

