package cmu.hopon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="location", schema = "public")
public class Location {

    @Id
    String name;
    @OneToOne
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
