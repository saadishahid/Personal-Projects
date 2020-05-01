package persistence;

import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


//Test based on CPSC210 TellerApp implementation
/**Handles Test for Writer Class in persistence**/

class WriterTest {

    private static final String TEST_FILE = "./data/testWriter.txt";
    private Writer testWriter;
    private Player player1;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        player1 = new Player("Saad 200");
    }

    @Test
    void testWriteAccounts() {
        // save player information to file
        testWriter.write(player1);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
      /*  try {
            List<Player> accounts = Reader.readAccounts(new File(TEST_FILE));
            Player player1 = player.get(0);
            assertEquals(1, chequing.getId());
            assertEquals("Mae", chequing.getName());
            assertEquals(123.56, chequing.getBalance());

            Account savings = accounts.get(1);
            assertEquals(2, savings.getId());
            assertEquals("Jo", savings.getName());
            assertEquals(435.23, savings.getBalance());

            // verify that ID of next account created is 3 (checks that nextAccountId was restored)
            Account next = new Account("Chris", 0.00);
            assertEquals(3, next.getId());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }*/
    }
}