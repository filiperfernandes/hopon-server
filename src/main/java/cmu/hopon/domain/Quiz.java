package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="quiz", schema = "public")
public class Quiz {

    @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToMany
    List<Question> questionsList = new ArrayList<>();

    public List<Question> getQuestionList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList){
        this.questionsList = questionsList;
    }

}
