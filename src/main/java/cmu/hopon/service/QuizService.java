package cmu.hopon.service;

import cmu.hopon.domain.Quiz;
import cmu.hopon.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    public Quiz addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return quiz;
    }

    public Iterable<Quiz> getQuiz(){
        return quizRepository.findAll();
    }
}
