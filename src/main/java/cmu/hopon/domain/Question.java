package cmu.hopon.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question", schema = "public")
public class Question {

    @Id
    int id;
    String question;
    String rightAnswer;

    @ElementCollection
    List<String> options = new ArrayList<String>();

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getRightAnswer(){
        return rightAnswer;
    }

    public void setRightAnswer(String question){
        this.rightAnswer = rightAnswer;
    }

}
