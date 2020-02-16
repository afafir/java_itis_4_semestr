package facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Kladr;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TreeSaver {
    void saveTree(Kladr kladr) throws IOException;

    Kladr getTree() throws IOException;
}
