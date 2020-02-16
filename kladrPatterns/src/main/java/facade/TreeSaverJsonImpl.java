package facade;


import com.fasterxml.jackson.databind.ObjectMapper;
import iterators.Iterator;
import model.Kladr;
import model.Node;

import java.io.File;
import java.io.IOException;

public class TreeSaverJsonImpl implements TreeSaver {

    private static TreeSaverJsonImpl instance;

    @Override
    public void saveTree(Kladr kladr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("kladr.json"), kladr);

    }

    @Override
    public Kladr getTree() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Kladr kladr = mapper.readValue(new File("kladr.json"), Kladr.class);
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
    private TreeSaverJsonImpl(){
    }
    public static TreeSaverJsonImpl getInstance(){
       if(instance == null){
            instance = new TreeSaverJsonImpl();
       }
       return instance;
    }
}
