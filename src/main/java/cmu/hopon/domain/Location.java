package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="location", schema = "public")
public class Location {

    @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO)
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