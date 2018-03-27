package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question", schema = "public")
public class Question {

    @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String question;
    String rightAnswer;

    @ElementCollection
    List<String> options;

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getRightAnswer(){
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer){
        this.rightAnswer = rightAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions (List<String> options) {
        this.options = options;
    }

}
