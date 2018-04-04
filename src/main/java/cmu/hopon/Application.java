package cmu.hopon;

import cmu.hopon.domain.Location;
import cmu.hopon.domain.Question;
import cmu.hopon.domain.Quiz;
import cmu.hopon.repository.LocationRepository;
import cmu.hopon.repository.QuestionRepository;
import cmu.hopon.repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    //Populate DB with locations and Quizzes

    @Bean
    public CommandLineRunner populateQuestion(QuestionRepository questionRepository, QuizRepository quizRepository, LocationRepository locationRepository){
        return (args) -> {

            //Populate Questions
            Question question1 = new Question();


            List<String> options = new ArrayList<>();
            String rAns = "Belem";
            options.add(rAns);
            options.add("Alcanena");
            options.add("Londres");
            options.add("Porto");

            question1.setQuestion("Onde fica a Torre de Belém?");
            question1.setRightAnswer("Belem");
            question1.setOptions(options);

            questionRepository.save(question1);

            Question question2 = new Question();


            List<String> options2 = new ArrayList<>();
            String rAns2 = "Belem2";
            options2.add(rAns2);
            options2.add("Alcanena2");
            options2.add("Londres2");
            options2.add("Porto2");

            question2.setQuestion("Onde fica a Torre de Belém2?");
            question2.setRightAnswer("Belem2");
            question2.setOptions(options2);

            questionRepository.save(question2);

            //Populate Quizzes
            List<Question> questionList = new ArrayList<>();
            questionList.add(question1);
            questionList.add(question2);

            Quiz quiz1 = new Quiz();
            quiz1.setQuestionsList(questionList);
            quizRepository.save(quiz1);


            //Populate Locations
            Location location1 = new Location();

            location1.setName("Torre de Belem");
            location1.setQuiz(quiz1);

            locationRepository.save(location1);
//TESTE




        };
    }

}