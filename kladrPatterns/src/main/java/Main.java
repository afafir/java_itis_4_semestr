import facade.TreeSaverReader;
import facade.TreeSaverReaderJsonImpl;
import interpretor.InterpreterClient;
import iterators.Iterator;
import model.Kladr;
import model.Node;
import util.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        Node russia = new Node("Россия", Type.COUNTRY, 1);
        Node chuvashia = new Node("Чувашия", Type.REGION, (byte) 1);
        Node baskiria = new Node("Башкирия", Type.REGION, (byte) 2);
        Node cheboskRayon = new Node("Чебоксарский район", Type.DISTRICT, (byte) 1);
        Node cheboksary = new Node("Чебоксары", Type.CITY, (byte) 2);
        Node ishleevo = new Node("Ишлеево", Type.CITY, (byte)1);


        List<Node> regions = new ArrayList<>(Arrays.asList(chuvashia, baskiria));
        russia.setChildren(regions);
        chuvashia.setParent(russia);
        baskiria.setParent(russia);

        List<Node> districts = new ArrayList<>(Arrays.asList(cheboskRayon));
        chuvashia.setChildren(districts);
        cheboskRayon.setParent(chuvashia);


        List<Node> cities = new ArrayList<>(Arrays.asList(cheboksary, ishleevo));
        cheboskRayon.setChildren(cities);
        cheboksary.setParent(cheboskRayon);
        ishleevo.setParent(cheboskRayon);


        Kladr kladr = new Kladr(russia);
        Iterator iterator = kladr.getRoot().bfsIterator();

        while (iterator.hasNext()){
            Node node = (Node) iterator.next();
            System.out.println(node.getName());
        }

        InterpreterClient client = new InterpreterClient(kladr.getRoot());

        TreeSaverReader saver = TreeSaverReaderJsonImpl.getInstance();
        saver.saveTree(kladr, "kladr");
        Kladr kladr1 = saver.getTree("kladr");

        System.out.println(1);
    }
}
