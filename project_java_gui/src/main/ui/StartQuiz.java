

package ui;


import exceptions.InvalidAnswerException;

/**StartQuiz contains main method from which Console Based Quiz is run**/

public class StartQuiz {
    public static void main(String[] args) {
        try {
            new QuizRunner();
        } catch (InvalidAnswerException e) {
            System.out.println("Invalid Answer");

        }
    }
}


