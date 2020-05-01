
package ui;

import exceptions.InvalidAnswerException;
import model.ListOfQuestions;
import model.Player;
import model.SavePlayer;


import java.util.Scanner;

/**
 * QuizRunner class handles all the IO operation on the console based Quiz
 **/

public class QuizRunner {
    ListOfQuestions questions = new ListOfQuestions();
    Scanner userInput = new Scanner(System.in);

    public QuizRunner() throws InvalidAnswerException {
        runQuiz();
        endSegment();
    }


    public void runQuiz() throws InvalidAnswerException {

        System.out.println("Enter Name: \n");
        String s = userInput.nextLine();

        for (int i = 0; i < questions.questionList.size(); i++) {
            questions.showQuestion(i);
            String questionAnswer = userInput.nextLine();

            questions.checkAnswer(i, questionAnswer);
            if (Integer.parseInt(questionAnswer) < 0 | (Integer.parseInt(questionAnswer) > 3)) {
                throw new InvalidAnswerException();
            }
            scoreQuestionTracker(i);
        }
        int totalPoints = questions.getScore();
        System.out.println("You got " + totalPoints + " out of " + (10 * questions.questionList.size()) + " points.");
        Player plyr = new Player(s + " " + totalPoints);
        new SavePlayer(plyr);


    }
    //Requires: integer
    //Effects: Track Points and Questions Answered

    private void scoreQuestionTracker(int i) {
        System.out.println("Your points so far:" + questions.getScore());
        System.out.println("Questions answered so far:" + (i + 1));

    }



    //Poor Cohesion

   /* private void savePlayer() {
        try {
            Writer writer = new Writer(new File(Player_Record));
            writer.write(plyr);
            writer.close();
            System.out.println("Player record saved to file " + Player_Record);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save record to " + Player_Record);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
*/

    private void endSegment() {
        System.out.println("Goodbye");
    }


}
