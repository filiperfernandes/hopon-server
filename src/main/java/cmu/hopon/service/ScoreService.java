package cmu.hopon.service;

import cmu.hopon.domain.Score;
import cmu.hopon.domain.User;
import cmu.hopon.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public Iterable<Score> getScores() {
        return scoreRepository.findAll();
    }
}
