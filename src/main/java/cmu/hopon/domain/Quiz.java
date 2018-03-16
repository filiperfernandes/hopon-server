package cmu.hopon.domain;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    @OneToMany
    List<Question> questionsList = new ArrayList<>();

    public List<Question> getQuestion() {
        return questionsList;
    }

}
