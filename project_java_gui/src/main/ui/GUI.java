package ui;

import exceptions.InvalidAnswerException;
import model.ListOfQuestions;
import model.Question;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


/**GUI class is responsible for designing GUI and assist in running of Quiz**/

public class GUI implements ActionListener {
    ListOfQuestions listGui = new ListOfQuestions();
    String nameString;
    String pointString;
    int counter = 0;

    JFrame window = new JFrame();
    JPanel headingPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel questionAddPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel scoreTracker = new JLabel();
    JLabel question = new JLabel("Questions");
    JLabel questionsSoFar = new JLabel();
    JLabel saveJLabel = new JLabel();
    JTextField name = new JTextField("Enter Name Here");
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);


    JTextArea questionAdder = new JTextArea("Your Question Here");
    JTextField firstOption = new JTextField("Option 1");
    JTextField secondOption = new JTextField("Option 2");
    JTextField thirdOption = new JTextField("Option 3");
    JTextField correctOption = new JTextField("Correct Option Number");

    //Adding JButtons with AbstractAction

    JButton option1 = new JButton(new AbstractAction("Option 1") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                listGui.checkAnswer((counter), "1");
            } catch (InvalidAnswerException ex) {
                ex.printStackTrace();
            }
            updateQuestionScore();
        }
    });


    JButton option2 = new JButton(new AbstractAction("Option 2") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                listGui.checkAnswer((counter), "2");
            } catch (InvalidAnswerException ex) {
                ex.printStackTrace();
            }
            updateQuestionScore();
        }
    });


    JButton option3 = new JButton(new AbstractAction("Option 3") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                listGui.checkAnswer((counter), "3");
            } catch (InvalidAnswerException ex) {
                ex.printStackTrace();
            }
            updateQuestionScore();
        }
    });


    JButton saveButton = new JButton(new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            saveInfo();
        }
    });

    JButton lastPlayerInfo = new JButton(new AbstractAction("Last Player Info") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                lastPlayer();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    });


    JButton addCustomQuestion = new JButton(new AbstractAction("Add Custom Question") {
        @Override
        public void actionPerformed(ActionEvent e) {
            addQuestion();

        }
    });

    JButton saveQuestion = new JButton("Save Question");


//Constructor

    public GUI() {
        setFrame();
        setHeadingPanel();
        setQuestionPanel();
        addOptions();
    }
//Effects: Setup questionPanel GUI


    private void setQuestionPanel() {
        questionPanel.add(question);
        question.setVerticalAlignment(SwingConstants.CENTER);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setText((questionFormat(listGui.showQuestion(counter))));
        question.setFont(new Font("Serif", Font.PLAIN, 18));
    }
//Effects: Setup headingPanel GUI

    private void setHeadingPanel() {
        headingPanel.setBackground(Color.pink);
        headingPanel.setVisible(true);
        headingPanel.add(scoreTracker);
        headingPanel.add(questionsSoFar);
        scoreTracker.setVerticalAlignment(SwingConstants.TOP);
        scoreTracker.setHorizontalAlignment(SwingConstants.LEFT);
    }
// Effects: Setup JFrame

    private void setFrame() {
        window.setTitle("Rock and Roll Trivia");
        window.setSize(800, 800);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(headingPanel, BorderLayout.PAGE_START);
        window.add(questionPanel, BorderLayout.CENTER);
        window.add(buttonPanel, BorderLayout.PAGE_END);
    }

//Effects: Add option buttons on buttonPanel

    private void addOptions() {
        buttonPanel.add(option1);
        buttonPanel.add(option2);
        buttonPanel.add(option3);
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
    }


//REQUIRES: String
//EFFECTS: Format the question string into GUI friendly version

    private static String questionFormat(String unformattedQuestion) {
        return "<html>" + unformattedQuestion.replaceAll("\n", "<br>");
    }

    //EFFECTS: Gets question from array list and add on panel
    public void getQuestion() {

        if (counter < listGui.questionList.size()) {
            question.setText((questionFormat(listGui.showQuestion(counter))));
            question.setFont(new Font("Serif", Font.PLAIN, 18));
        } else {
            question.setText(questionFormat("Game Over"));
            questionPanel.add(name);
            changeButton();

        }
        scoreTracker.setText("Total Score:" + " " + listGui.getScore());
        questionsSoFar.setText("Question answered so far:" + " " + counter);


    }


    private void updateQuestionScore() {
        counter++;
        getQuestion();
    }


    //From www.stackoverflow.com/questions.32143648/how-to-save-jtextfield-value-to-a-file-as-a-log
//Save Textfile for Last Player Info
    private void saveInfo() {
        question.remove(name);
        nameString = name.getText();
        pointString = Integer.toString(listGui.getScore());

        String saveContent = nameString + " " + pointString;

        try {
            File file = new File("./data/Player_Record.txt");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(saveContent);
            bufferedWriter.close();
            question.setText("Player Info Saved");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //From https://stackoverflow.com/questions/731365/reading-and-displaying-data-from-a-txt-file
//Effects: Read Text file for Last Player Info
    private void lastPlayer() throws FileNotFoundException {
        File file = new File("./data/Player_Record.txt");
        String fileContents = new Scanner(file).useDelimiter("\\Z").next();
        question.setText(questionFormat(fileContents));

    }

//EFFECTS: Set buttons for end of quiz

    private void changeButton() {
        buttonPanel.remove(option1);
        buttonPanel.remove(option2);
        buttonPanel.remove(option3);
        // buttonPanel.remove(option4);

        buttonPanel.add(saveButton);
        buttonPanel.add(lastPlayerInfo);
        buttonPanel.add(addCustomQuestion);
        lastPlayerInfo.addActionListener(this);
        saveButton.addActionListener(this);
        addCustomQuestion.addActionListener(this);

    }
//Modifies: ListOfQuestion in ListOfQuestions Class
//Effects: Add Question to the ListOfQuestion

    private void addQuestion() {
        addQuestionGUI();


    }

//Effects: Create GUI for addQuestion()

    private void addQuestionGUI() {
        window.remove(questionPanel);
        window.add(questionAddPanel, BorderLayout.CENTER);
        questionAddPanel.add(questionAdder);
        questionAdder.setBorder(border);
        questionAdder.setAlignmentX(100);
        questionAdder.setAlignmentY(100);
        questionAdder.setFont(new Font("Serif", Font.PLAIN, 18));
        buttonPanel.remove(saveButton);
        buttonPanel.remove(lastPlayerInfo);
        buttonPanel.remove(addCustomQuestion);
        buttonPanel.add(firstOption);
        firstOption.setBorder(border);
        buttonPanel.add(secondOption);
        secondOption.setBorder(border);
        buttonPanel.add(thirdOption);
        thirdOption.setBorder(border);
        buttonPanel.add(correctOption);
        correctOption.setBorder(border);
        buttonPanel.add(saveQuestion);
        saveQuestion.addActionListener(this);

    }

//Effects: Save Question to the ListOfQuestions()

    private void saveAddedQuestion() {

        listGui.questionAdd(questionAdder.getText() + firstOption.getText()
                + secondOption.getText() + thirdOption.getText(), correctOption.getText());
        headingPanel.add(saveJLabel);
        saveJLabel.setText("Question Saved");
        questionsSoFar.setText(Integer.toString(listGui.questionList.size()));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveQuestion) {
            saveAddedQuestion();
        }
    }
}

