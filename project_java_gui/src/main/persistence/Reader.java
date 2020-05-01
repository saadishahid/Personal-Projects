package persistence;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

//Implemented from CPSC 210 Teller APP

/**A reader that can read name and score data from a file**/


public class Reader {
    public static final String DELIMITER = ",";


    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    public static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }


}
