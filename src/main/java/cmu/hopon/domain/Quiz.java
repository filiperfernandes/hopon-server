package cmu.hopon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="quiz", schema = "public")
public class Quiz {

    @Id
    int id;

    @OneToMany
    List<Question> questionsList = new ArrayList<>();

    public List<Question> getQuestion() {
        return questionsList;
    }

}
