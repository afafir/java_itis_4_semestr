package facade;


import com.fasterxml.jackson.databind.ObjectMapper;
import iterators.Iterator;
import model.Kladr;
import model.Node;

import java.io.File;
import java.io.IOException;

public class TreeSaverReaderJsonImpl implements TreeSaverReader {

    private static TreeSaverReaderJsonImpl instance;

    @Override
    public void saveTree(Kladr kladr, String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(pathname+".json"), kladr);

    }

    @Override
    public Kladr getTree(String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Kladr kladr = mapper.readValue(new File(pathname+".json"), Kladr.class);
        Iterator<Node> iterator = kladr.getRoot().bfsIterator();
        while (iterator.hasNext()) {
            Node curr = iterator.next();
            if (curr.getChildren() != null) {
                curr.getChildren().forEach(x -> x.setParent(curr));
            }
        }
        return kladr;
    }

        //singleton
    private TreeSaverReaderJsonImpl(){
    }
    public static TreeSaverReaderJsonImpl getInstance(){
       if(instance == null){
            instance = new TreeSaverReaderJsonImpl();
       }
       return instance;
    }
}
