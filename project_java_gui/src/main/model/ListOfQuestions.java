package model;


import exceptions.InvalidAnswerException;

import java.util.ArrayList;


import static model.Question.*;

/**ListOfQuestions is responsible to make the List of Questions on the Quiz**/

public class ListOfQuestions {
    int score = 0;
    public ArrayList<Question> questionList;


    //Constructor
    public ListOfQuestions() {
        //creates a questionList arraylist

        questionList = new ArrayList<>();
        questionList.add(new Question(ques1, ans1));

        questionList.add(new Question(ques2, ans2));

        questionList.add(new Question(ques3, ans3));

    }

//Effects:Add a question to the list

    public void questionAdd(String questionBody, String questionAnswer) {
        questionList.add(new Question(questionBody, questionAnswer));
    }


//Effects: Show Question from the list

    public String showQuestion(int i) {
        System.out.println(questionList.get(i).getQuestionBody());
        return (questionList.get(i).getQuestionBody());
    }

//Effects: Check Answer of the question

    public void checkAnswer(int i, String s) throws InvalidAnswerException {
        int p;
        if ((Integer.parseInt(s) < 0 | (Integer.parseInt(s) > 3))) {
            throw new InvalidAnswerException();
        }
        if (s.equals(questionList.get(i).getQuestionAnswer())) {

            updateScore(10);
        } else {
            updateScore(0);
        }
    }

    //Low Cohesion

    public void updateScore(int p) {

        score = score + p;
        //System.out.println("Your points so far:" + score);

    }

    public int getScore() {
        return score;
    }


}
