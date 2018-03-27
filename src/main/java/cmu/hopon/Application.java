package cmu.hopon;

import cmu.hopon.domain.Location;
import cmu.hopon.domain.Question;
import cmu.hopon.domain.Quiz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        populate();

        SpringApplication.run(Application.class, args);
    }

    public static void populate(){

        //Populate DB with locations and Quizzes

/*        Location loc = new Location();
        Quiz quiz = new Quiz();
        Question quest = new Question();




        loc.setName("Mosteiro dos Jerónimos");
        loc.setQuiz(quiz);*/

    }
}