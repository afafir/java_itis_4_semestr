package facade;

import model.Kladr;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TreeSaverReaderXMLimpl implements TreeSaverReader {
    private static TreeSaverReaderXMLimpl instance;

    @Override
    public void saveTree(Kladr kladr, String pathname) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File(pathname+".xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(fos);
        xmlEncoder.writeObject(kladr);
        xmlEncoder.flush();
        xmlEncoder.close();
    }





    @Override
    public Kladr getTree(String pathname) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File(pathname+".xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        return (Kladr) decoder.readObject();
    }

    //singleton
    private TreeSaverReaderXMLimpl(){
    }
    public static TreeSaverReaderXMLimpl getInstance(){
        if(instance == null){
            instance = new TreeSaverReaderXMLimpl();
        }
        return instance;
    }
}
