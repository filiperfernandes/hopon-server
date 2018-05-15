package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "public", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class User {

    @Id @Column(unique=true, nullable=false)
    String username; //unique
    String token;

    @OneToOne @JoinColumn(name = "score")
    Score score;

    @Column(unique=true, nullable=false)
    long code; //never used before

    @OneToOne
    Score currentScore;
    private String currentMonument;

    @ElementCollection
    private List<String> answeredLocations = new ArrayList<>();

    @Column(length = 500)
    private String pubk;

    public User(){
    }

    public User(String username, long code, String token, Score score, Score currentScore,
                String currentMonument, List<String> answeredLocations, String pubk){
        this.code=code;
        this.username=username;
        this.token=token;
        this.score=score;
        this.currentScore=currentScore;
        this.currentMonument=currentMonument;
        this.answeredLocations=answeredLocations;
        this.pubk=pubk;
    }

    public User(String username, String token){
        this.username=username;
        this.token=token;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getToken () {

        return token;
    }
    
    public void setToken (String token) {
        
        this.token = token;
    }

    public long getCode () {

        return code;
    }

    public void setCode(long code) {

        this.code = code;
    }

    public Score getScore () {

        return score;
    }

    public void setScore(Score score) {

        this.score = score;
    }

    public void setCurrentMonument(String currentMonument) {
        this.currentMonument = currentMonument;
    }

    public void setCurrentScore(Score currentScore) {
        this.currentScore = currentScore;
    }

    public Score getCurrentScore() {
        return currentScore;
    }

    public String getCurrentMonument() {
        return currentMonument;
    }

    public void setAnsweredLocations(List<String> answeredLocations) {
        this.answeredLocations = answeredLocations;
    }

    public List<String> getAnsweredLocations() {
        return answeredLocations;
    }

    public void setPubk(String pubk){
        this.pubk=pubk;
    }

    public String getPubk(){
        return pubk;
    }

}
