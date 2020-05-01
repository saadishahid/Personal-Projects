# Know your Rock! 

## Rock and Roll Trivia


Please grade for P3 and P4.

The project will test player's knowledge of Rock music. Player will be asked a series of questions. 
Each question will be worth 10 points. Each question will be accompanied with 4 choices of answers amongst which one 
answer is the correct one. Questions will get harder as the game 
progresses. The program will keep track of
- Player's score
- Questions already asked (so as not to repeat the same question)

The game will run for at least 3 questions.



##User Stories
As a user, I want to:

1. Add custom questions to the question List.
2. Know my score at the end of the game.
3. Continuously see how many questions I have attempted during the game
4. Continuously see my score during the game.
5. Save player name and score in a text file after completing the quiz.
6. Load the name and score of last player from the text file (who played prior to the current session).


## Instructions for Grader
The code can be executed through the Main class in the ui package.

You can generate the first required event by:<br>

(a) Observing that questions are displayed that are setup in Question Class (X) and ListOfQuestions class (Y) <br>

(b) Observing that a button is added for adding custom questions at the end of the program, which allows user to add 
their own questions to the question list. A counter is also added in the heading panel to update when a user adds a 
question to the list.

You can generate the second required event by:<br>

(a) Viewing questions from in JLabels and answers are verified through JButtons in each question

You can trigger my audio component by:<br>

(a) Pressing the "Save" button (to save player name and stats). A system default beep would be heard.

You can save the state of my application by:<br>

(a) Pressing the "Save" button at the end of quiz.

You can reload the state of my application by:<br>

(a) Pressing the "Last Player Info" button.


##Phase 4: Task 2
Test and design a class that is robust is the chosen option


ListOfQuestions class (package: model) has a method called checkAnswer which takes in an integer and a String. 
The checkAnswer method will throw an InvalidAnswerException (Exception class made in exceptions package) when the String
parameter is not "1", "2", or "3". The runQuiz method in QuizRunner class, which calls the checkAnswer method from
ListOfQuestions class and throws the exception which is finally caught in the main method of the StartQuiz class.

The GUI class (package:ui) also calls the checkAnswer method from ListOfQuestions class (package: model) and exception 
is handled within the ActionListeners in GUI class.

In Test Package QuizTest class, tests where exception is not expected can be found in test method <br>
<br>checkCorrectAnswerTest <br>
<br>and test where exception is expected<br><br>
checkInvalidAnswerTest

##Phase 4: Task 3
After analyzing the code, <br>
Made a separate class called SavePlayer which was previously done in the QuizRunner class
As QuizRunner class is responsible for IO and UI operation of console based quiz running. <br>
<br>
Created a method called scoreQuestionTracker in QuizRunner class which tracks the score and number of question answered.
Previously the functionality was incorporated in runQuiz method in QuizRunner class.

