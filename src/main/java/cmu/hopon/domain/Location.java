package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="location", schema = "public")
public class Location {

    @TableGenerator(name = "id_gen", initialValue = 0)

    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
    int id;

    //@Id
    String name;
    @OneToOne
    @JoinColumn(name = "quiz", nullable = false)
    Quiz quiz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
