package model;

import exceptions.InvalidAnswerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.junit.jupiter.api.Assertions.*;
/**Test Class for Model Package**/

class QuizTest {
    ListOfQuestions testList = new ListOfQuestions();

    Question q1;
    Question q2;
    Question q3;


    @BeforeEach
    void runBefore() {

        q1 = new Question("Which band was Kurt Cobain in?\n" + "(1) Pearl Jam\n"
                + "(2) Gun N' Roses\n"
                + "(3) Nirvana\n"
                + "(4) Heart\n", "3");

        q2 = new Question("Who was the youngest Beatle?\n" + "(1) Paul\n"
                + "(2) John\n"
                + "(3) Ringo\n"
                + "(4) George\n", "4");

        q3 = new Question("Which is the longest remaining album on the Billboard Charts?\n" + "(1) DSOTM\n"
                + "(2) Appetite for Destruction\n"
                + "(3) Van Halen\n"
                + "(4) O.K. Computer\n", "1");
    }

    @Test
    void testConstructor() {
        assertEquals(3, testList.questionList.size());
    }


    @Test
    void addQuestion() {
        testList.questionList.add(q1);
        assertEquals(4, testList.questionList.size());
    }

    @Test
    void getQuestion() {
        assertEquals(3, testList.questionList.size());

    }

    @Test
    void checkCorrectAnswerTest() {
        String answer = "3";
        try {
            testList.checkAnswer(0, answer);
        } catch (InvalidAnswerException e) {
            System.out.println("Invalid Answer");
        }
        assertEquals(10, testList.getScore());

    }

    @Test
    void checkWrongValidAnswer() {
        String answer = "1";
        try {
            testList.checkAnswer(0, answer);
        } catch (InvalidAnswerException e) {
            System.out.println("Invalid Answer");
        }
        assertEquals(0, testList.getScore());
    }

    @Test
    void checkInvalidAnswerTest() {
        String answer = "5";
        try {
            testList.checkAnswer(0, answer);
        } catch (InvalidAnswerException e) {
            System.out.println("Invalid Answer");
        }
    }

    @Test
    void checkShowAnswer() {
        testList.questionList.add(q1);
        assertEquals("Which band was Kurt Cobain in?\n" + "(1) Pearl Jam\n"
                + "(2) Gun N' Roses\n"
                + "(3) Nirvana\n"
                + "(4) Heart\n", testList.showQuestion(3));
    }
}
/*
    @Test
    void testHighScorers() {

        s1 = new ScoreTracker("Saad", 100);
        highScoreCheck.addHighScore(s1);
        assertEquals(1, highScoreCheck.highScore.size());
    }*/
