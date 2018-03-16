package cmu.hopon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user", schema = "public")
public class User {

    @Id
    String username; //unique
    String token;
    int code; //never used before
    int ID;




    public int getID() {

        return ID;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public String getUserName() {

        return username;
    }

    public void setUserName(String username) {

        this.username = username;
    }

    public String getToken () {

        return token;
    }
    
    public void setToken (String token) {
        
        this.token = token;
    }

    public int getCode () {

        return code;
    }

    public void setCode(int code) {

        this.code = code;
    }





}
