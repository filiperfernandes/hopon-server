package cmu.hopon.domain;

import javax.persistence.*;

@Entity
@Table(name="location", schema = "public")
public class Location {

    @Id
    String name;
    @OneToOne
    @JoinColumn(name = "quiz", nullable = false)
    Quiz quiz;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quiz getQuiz(){
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }


}
