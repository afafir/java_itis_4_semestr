package browser;

import Momento.Memento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Data
@AllArgsConstructor
@Builder
public class Browser {
    private Page currentPage;
    private List<Page> allPages;
    private History history;


    public Browser() {
        allPages = new ArrayList<>();
        history = new History();
        try (FileReader reader = new FileReader("src/pages.txt")) {
            Scanner sc = new Scanner(reader);
            String line;
            //считываем страницы
            while (!(line = sc.nextLine()).equals("---links----")) {
                Page page = new SimplePage(line);
                allPages.add(page);
            }
            //считываем ссылки каждой страницы
            for (Page page : allPages) {
                List<Page> linkablePages = new ArrayList<>();
                String[] links = sc.nextLine().split(" ");
                for (String link : links) {
                    for (Page page1 : allPages) {
                        if (page1.getUrl().equals(link)) {
                            linkablePages.add(page1);
                        }
                    }
                }
                page.setLinkablePages(linkablePages);
            }
            currentPage = allPages.get(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new IllegalStateException();
        }

    }


    public Memento saveMemento() {
        return new Memento(this, currentPage);
    }
}
