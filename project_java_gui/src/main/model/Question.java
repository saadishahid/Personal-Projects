package model;

/**Question class contains the question constructor and predefined question body and answers for running quiz**/

public class Question {
    private String questionBody;
    private String questionAnswer;

    //Constructor
    public Question(String body, String answer) {
        this.questionBody = body;
        this.questionAnswer = answer;
    }

    //EFFECTS: getter for Question body
    public String getQuestionBody() {
        return questionBody;
    }

    // EFFECTS: getter for question answer

    public String getQuestionAnswer() {
        return questionAnswer;
    }


    //Making questionBody for questions
    public static String ques1 = "Which Led Zeppelin album has Stairway to heaven?\n"
            + "(1) Houses of the Holly\n"
            + "(2) Led Zeppelin I\n"
            + "(3) Led Zeppelin IV\n";


    public static String ques2 = "Who played drums for the Beatles\n"
            + "(1) Ringo\n"
            + "(2) John\n"
            + "(3) Paul\n";


    public static String ques3 = "Who was Jimi Hendrix?\n"
            + "(1) Bass player\n"
            + "(2) Guitarist\n"
            + "(3) Banjo player\n";

    //Making questionAnswer for questions
    public static String ans1 = "3";
    public static String ans2 = "1";
    public static String ans3 = "2";

/*
    // EFFECTS: returns Question body of this Question item
    public String getQuestionBody() {
        return questionBody;
    }

    // EFFECTS: returns Answer (as String) of this Question
    public String getQuestionAnswer() {
        return questionAnswer;
    }*/


}



