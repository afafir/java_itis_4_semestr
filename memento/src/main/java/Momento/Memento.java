package Momento;


import browser.Browser;
import browser.Page;
import browser.SimplePage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memento {
    private Browser browser;
    private Page currentPage;


    public void createFromSnapshot(Browser browser) {
        browser.setCurrentPage(currentPage);
    }
}
