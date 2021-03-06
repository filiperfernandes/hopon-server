package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="score", schema = "public")
public class Score {

    @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    int correct;

    int answered;

    double elapsedSeconds;

    public int getCorrect () {

        return correct;
    }

    public void setCorrect(int correct) {

        this.correct = correct;
    }

    public int getAnswered () {

        return answered;
    }

    public void setAnswered(int answered) {

        this.answered = answered;
    }

    public double getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(double elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }
}
