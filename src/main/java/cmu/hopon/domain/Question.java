package cmu.hopon.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {

    String question;
    String rightAnswer;
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
