package cmu.hopon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;

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

/*    @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }*/

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


}
