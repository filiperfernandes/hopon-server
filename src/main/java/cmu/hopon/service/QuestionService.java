package cmu.hopon.service;

import cmu.hopon.domain.Question;
import cmu.hopon.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        questionRepository.save(question);
        return question;
    }

    public Iterable<Question> getQuestions(){
        return questionRepository.findAll();
    }
}
