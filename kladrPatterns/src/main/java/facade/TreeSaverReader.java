package facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Kladr;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TreeSaverReader {
    void saveTree(Kladr kladr, String pathname) throws IOException;

    Kladr getTree(String pathname) throws IOException;
}
