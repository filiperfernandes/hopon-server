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



            // Pop. JQuestion1
            Question jQuestion1 = new Question();


            List<String> jOptions = new ArrayList<>();
            String jRAns = "Belem";
            jOptions.add(jRAns);
            jOptions.add("Benfica");
            jOptions.add("Jeronimos");
            jOptions.add("Porto");

            jQuestion1.setQuestion("Onde fica o Mosteiro dos Jerónimos?");
            jQuestion1.setRightAnswer(jRAns);
            jQuestion1.setOptions(jOptions);

            questionRepository.save(jQuestion1);

            // Pop. JQuestion2
            Question jQuestion2 = new Question();


            List<String> jOptions2 = new ArrayList<>();
            String jRAns2 = "Manuelino";
            jOptions2.add("Barroco");
            jOptions2.add("Gótico");
            jOptions2.add(jRAns2);
            jOptions2.add("Moderno");

            jQuestion2.setQuestion("Qual o estilo dominante do Mosteiro dos Jerónimos?");
            jQuestion2.setRightAnswer(jRAns2);
            jQuestion2.setOptions(jOptions2);

            questionRepository.save(jQuestion2);

            //Populate JQuizzes 1
            List<Question> jQuestionList = new ArrayList<>();
            jQuestionList.add(jQuestion1);
            jQuestionList.add(jQuestion2);

            Quiz jeronimosQuiz = new Quiz();
            jeronimosQuiz.setQuestionsList(jQuestionList);
            quizRepository.save(jeronimosQuiz);

            //Populate Locations3
            Location jeronimos = new Location();

            jeronimos.setName("Mosteiro dos Jerónimos");
            jeronimos.setQuiz(jeronimosQuiz);

            locationRepository.save(jeronimos);



            //PORTO LOCATION

            // Pop. PQuestion1
            Question pQuestion1 = new Question();


            List<String> pOptions = new ArrayList<>();
            String pRAns = "Porto";
            pOptions.add("Abrantes");
            pOptions.add("Coimbra");
            pOptions.add("Viseu");
            pOptions.add(pRAns);

            pQuestion1.setQuestion("Onde fica a Torre dos Clérigos?");
            pQuestion1.setRightAnswer(pRAns);
            pQuestion1.setOptions(pOptions);

            questionRepository.save(pQuestion1);

            // Pop. pQuestion2
            Question pQuestion2 = new Question();


            List<String> pOptions2 = new ArrayList<>();
            String pRAns2 = "Barroco";
            pOptions2.add("Manuelino");
            pOptions2.add("Gótico");
            pOptions2.add(pRAns2);
            pOptions2.add("Moderno");

            pQuestion2.setQuestion("Qual o estilo dominante da Torre dos Clérigos?");
            pQuestion2.setRightAnswer(pRAns2);
            pQuestion2.setOptions(pOptions2);

            questionRepository.save(pQuestion2);

            //Populate pQuizzes 1
            List<Question> pQuestionList = new ArrayList<>();
            pQuestionList.add(pQuestion1);
            pQuestionList.add(pQuestion2);

            Quiz clerigosQuiz = new Quiz();
            clerigosQuiz.setQuestionsList(pQuestionList);
            quizRepository.save(clerigosQuiz);

            //Populate Locations4
            Location clerigos = new Location();

            clerigos.setName("Torre dos Clérigos");
            clerigos.setQuiz(clerigosQuiz);

            locationRepository.save(clerigos);




        };
    }

}