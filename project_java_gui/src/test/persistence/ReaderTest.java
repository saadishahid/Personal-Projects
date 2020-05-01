package persistence;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**Implemented using TellerApp CPSC 210

//Handles Test for Reader Class in persistence**/

public class ReaderTest {
    @Test
    void testIOException() {
        try {
            Reader.readFile(new File("./path/does/not/exist/testPlayer.txt"));
        } catch (IOException e) {
            System.out.println("Can not read");
        }
    }
}
