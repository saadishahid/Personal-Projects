package model;

import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**Saves Player and Score to Text File by using Classes in persistence package**/

public class SavePlayer {
    private static final String Player_Record = "./data/Player_Record.txt";
    //Requires: Player Object
    //Effects:Saves player and score to text file

    public SavePlayer(Player plyr) {
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
}
