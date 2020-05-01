package model;

import persistence.Reader;
import persistence.SaveFile;

import java.io.PrintWriter;
import java.util.ArrayList;

/**Creates a player object which contain name and score of the player  **/

public class Player implements SaveFile {

    private String nameScore;

    //Constructs a Player Object that has player name and score in a single String
    public Player(String nameScore) {
        this.nameScore = nameScore;
    }


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(Reader.DELIMITER);
        printWriter.print(nameScore);
        printWriter.print(Reader.DELIMITER);


    }


}

