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

            // Pop. Question1
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

            // Pop. Question2
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


            // Pop. Question3
            Question question3 = new Question();

            List<String> options3 = new ArrayList<>();
            String rAns3 = "Eiffel";
            options3.add(rAns3);
            options3.add("Jacob");
            options3.add("Pina");
            options3.add("Filipe");

            question3.setQuestion("Quem desenhou a Torre Eiffel?");
            question3.setRightAnswer(rAns3);
            question3.setOptions(options3);

            questionRepository.save(question3);

            // Pop. Question4
            Question question4 = new Question();

            List<String> options4 = new ArrayList<>();
            String rAns4 = "Eiffel";
            options4.add(rAns4);
            options4.add("Ze Pedro");
            options4.add("Ze Pedro dos chutos");
            options4.add("Tiago");

            question4.setQuestion("Quem desenhou a Ponte D.Luis?");
            question4.setRightAnswer(rAns4);
            question4.setOptions(options4);

            questionRepository.save(question4);

            //Populate Quizzes 1
            List<Question> questionList = new ArrayList<>();
            questionList.add(question1);
            questionList.add(question2);

            Quiz quiz1 = new Quiz();
            quiz1.setQuestionsList(questionList);
            quizRepository.save(quiz1);

            //Populate Quizzes 2
            List<Question> questionList2 = new ArrayList<>();
            questionList2.add(question3);
            questionList2.add(question4);

            Quiz quiz2 = new Quiz();
            quiz2.setQuestionsList(questionList2);
            quizRepository.save(quiz2);



            //Populate Locations1
            Location location1 = new Location();

            location1.setName("Torre de Belem");
            location1.setQuiz(quiz1);

            locationRepository.save(location1);


            //Populate Locations2
            Location location2 = new Location();

            location2.setName("Torre Eiffel");
            location2.setQuiz(quiz2);

            locationRepository.save(location2);
//TESTE




        };
    }

}