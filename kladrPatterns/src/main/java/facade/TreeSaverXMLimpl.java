package facade;

import model.Kladr;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TreeSaverXMLimpl implements TreeSaver{
    private static TreeSaverXMLimpl instance;

    @Override
    public void saveTree(Kladr kladr) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File("kladr.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(fos);
        xmlEncoder.writeObject(kladr);
        xmlEncoder.flush();
        xmlEncoder.close();
    }





    @Override
    public Kladr getTree() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("kladr.xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        return (Kladr) decoder.readObject();
    }

    //singleton
    private TreeSaverXMLimpl(){
    }
    public static TreeSaverXMLimpl getInstance(){
        if(instance == null){
            instance = new TreeSaverXMLimpl();
        }
        return instance;
    }
}
