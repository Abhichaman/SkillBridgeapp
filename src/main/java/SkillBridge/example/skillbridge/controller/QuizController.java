package SkillBridge.example.skillbridge.controller;


import SkillBridge.example.skillbridge.entity.QuizQuestion;
import SkillBridge.example.skillbridge.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/quiz/{subject}")
    public ResponseEntity<List<QuizQuestion>> getBySubject(@PathVariable String subject){
        return ResponseEntity.ok(questionService.getQuestionsBySubject(subject));
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public QuizQuestion saveQuestion(@RequestBody QuizQuestion question) {
        return questionService.saveQuestion(question);
    }
}