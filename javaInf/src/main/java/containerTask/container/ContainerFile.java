package containerTask.container;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContainerFile implements Container{
    private static final String path = "names.txt";
    private File file;

    public ContainerFile(){
        file = new File(path);
    }

    @Override
    public void add(String name) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true), true);
            pw.println(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> out() {
        List<String> names = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = br.readLine()) != null) {
                names.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }
}
