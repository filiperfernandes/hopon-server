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
            String rAns2 = "Manuelino";
            options2.add("Barroco");
            options2.add("Pombalino");
            options2.add("Rococó");
            options2.add(rAns2);

            question2.setQuestion("Qual é o estilo da Torre de Belem?");
            question2.setRightAnswer(rAns2);
            question2.setOptions(options2);

            questionRepository.save(question2);

            // Pop. Belem Question3
            Question belemQuestion3 = new Question();


            List<String> belemQuestion3Options = new ArrayList<>();
            String belemQuestion3rAns = "XVI";
            belemQuestion3Options.add("XV");
            belemQuestion3Options.add("XIV");
            belemQuestion3Options.add(belemQuestion3rAns);
            belemQuestion3Options.add("XVIII");

            belemQuestion3.setQuestion("Em que século foi construida a Torre de Belem?");
            belemQuestion3.setRightAnswer(belemQuestion3rAns);
            belemQuestion3.setOptions(belemQuestion3Options);

            questionRepository.save(belemQuestion3);


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
            questionList.add(belemQuestion3);

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


            //Palacio da Pena

            // Pop. Pena Question1
            Question penaQuestion1 = new Question();


            List<String> penaOptions = new ArrayList<>();
            String penaRAns = "Sintra";
            penaOptions.add("Oeiras");
            penaOptions.add("Moscavide");
            penaOptions.add("Carcavelos");
            penaOptions.add(penaRAns);

            penaQuestion1.setQuestion("Onde fica o Plácio da Pena?");
            penaQuestion1.setRightAnswer(penaRAns);
            penaQuestion1.setOptions(penaOptions);

            questionRepository.save(penaQuestion1);

            // Pop. Pena Question2
            Question penaQuestion2 = new Question();


            List<String> penaOptions2 = new ArrayList<>();
            String penaRAns2 = "Arquitetura Revivalista";
            penaOptions2.add("Manuelino");
            penaOptions2.add("Gótico");
            penaOptions2.add(penaRAns2);
            penaOptions2.add("Moderno");

            penaQuestion2.setQuestion("Qual o estilo dominante da Torre dos Clérigos?");
            penaQuestion2.setRightAnswer(penaRAns2);
            penaQuestion2.setOptions(penaOptions2);

            questionRepository.save(penaQuestion2);

            //Populate Pena Quizzes 1
            List<Question> penaQuestionList = new ArrayList<>();
            penaQuestionList.add(penaQuestion1);
            penaQuestionList.add(penaQuestion2);

            Quiz penaQuiz = new Quiz();
            penaQuiz.setQuestionsList(penaQuestionList);
            quizRepository.save(penaQuiz);

            //Populate Palacio da pena
            Location pena = new Location();

            pena.setName("Palácio da Pena");
            pena.setQuiz(penaQuiz);

            locationRepository.save(pena);

            //Castelo de Guimarães

            // Pop. Guimaraes Question1
            Question gQuestion1 = new Question();


            List<String> gOptions = new ArrayList<>();
            String gRAns = "Todas as anteriores";
            gOptions.add("Oliveira do Castelo");
            gOptions.add("Concelho de Guimarães");
            gOptions.add("Distrito de Braga");
            gOptions.add(gRAns);

            gQuestion1.setQuestion("Onde fica o Castelo de Guimarães?");
            gQuestion1.setRightAnswer(gRAns);
            gQuestion1.setOptions(gOptions);

            questionRepository.save(gQuestion1);

            // Pop. Guimaraes Question2
            Question gQuestion2 = new Question();


            List<String> gOptions2 = new ArrayList<>();
            String gRAns2 = "Dom Afonso Henriques";
            gOptions2.add("Dom Sancho I");
            gOptions2.add("Dom Pedro I");
            gOptions2.add(gRAns2);
            gOptions2.add("Dom Filipe I");

            gQuestion2.setQuestion("Quem foi o primeiro Rei de Portugal?");
            gQuestion2.setRightAnswer(gRAns2);
            gQuestion2.setOptions(gOptions2);

            questionRepository.save(gQuestion2);

            //Populate Guimaraes Quizzes 1
            List<Question> gQuestionList = new ArrayList<>();
            gQuestionList.add(gQuestion1);
            gQuestionList.add(gQuestion2);

            Quiz gQuiz = new Quiz();
            gQuiz.setQuestionsList(gQuestionList);
            quizRepository.save(gQuiz);

            //Populate Guimaraes
            Location guimaraes = new Location();

            guimaraes.setName("Castelo de Guimarães");
            guimaraes.setQuiz(gQuiz);

            locationRepository.save(guimaraes);


            //Castelo de Óbidos

            // Pop. Obidos Question1
            Question oQuestion1 = new Question();


            List<String> oOptions = new ArrayList<>();
            String oRAns = "Santa Maria";
            oOptions.add("Venda das Raparigas");
            oOptions.add(oRAns);
            oOptions.add("Terra da Gaja");
            oOptions.add("Colo do Pito");

            oQuestion1.setQuestion("Em que terra se situa o Castelo de Óbidos?");
            oQuestion1.setRightAnswer(oRAns);
            oQuestion1.setOptions(oOptions);

            questionRepository.save(oQuestion1);

            // Pop. Obidos Question2
            Question oQuestion2 = new Question();


            List<String> oOptions2 = new ArrayList<>();
            String oRAns2 = "13 metros";
            oOptions2.add("10 metros");
            oOptions2.add(oRAns2);
            oOptions2.add("9.57 metros");
            oOptions2.add("17 metros");

            oQuestion2.setQuestion("Qual a altura máxima da muralha?");
            oQuestion2.setRightAnswer(oRAns2);
            oQuestion2.setOptions(oOptions2);

            questionRepository.save(oQuestion2);

            //Populate Obidos Quizzes 1
            List<Question> oQuestionList = new ArrayList<>();
            oQuestionList.add(oQuestion1);
            oQuestionList.add(oQuestion2);

            Quiz oQuiz = new Quiz();
            oQuiz.setQuestionsList(oQuestionList);
            quizRepository.save(oQuiz);

            //Populate Obidos
            Location obidos = new Location();

            obidos.setName("Castelo de Óbidos");
            obidos.setQuiz(oQuiz);

            locationRepository.save(obidos);

        };
    }

}