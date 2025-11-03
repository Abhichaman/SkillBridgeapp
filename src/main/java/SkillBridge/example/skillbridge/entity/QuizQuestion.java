package SkillBridge.example.skillbridge.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="subject_name")
    private String subject;



    @Column(name = "question_text")
    private String questiontext;
    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name = "question_options",joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text")
    private List<String> options;


    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
