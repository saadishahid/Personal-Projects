package persistence;

import java.io.PrintWriter;
//based on CPSC210 TellerApp example


public interface SaveFile {

    // Represents data that can be saved to file
    // MODIFIES: printWriter
    // EFFECTS: writes the saveFile to printWriter
    void save(PrintWriter printWriter);
}


