package command;

import browser.Browser;
import browser.Page;
import browser.SimplePage;
import java.util.Optional;
import java.util.Stack;

public class Interpreter {
    private Browser browser;

    public Interpreter(Browser browser){
        this.browser = browser;
    }


    public void goTo(String url) {
        Optional<Page> page;
        if ((page = browser.getAllPages().stream().filter(x -> x.getUrl().equals(url)).findAny()).isPresent()) {
            browser.setCurrentPage(page.get());
        } else System.out.println("This page doe\nsnt exist");
        browser.getHistory().setBack(new Stack<>());
        browser.getHistory().setForward(new Stack<>());
    }

    public void link(String url) {
        Optional<Page> page;
        if ((page = browser.getCurrentPage().getLinkablePages().stream().filter(x -> x.getUrl().equals(url)).findAny()).isPresent()) {
            browser.getHistory().getBack().push(browser.saveMemento());
            browser.setCurrentPage(page.get());
        } else System.out.println("You cant visit this url from this page");
    }

    public void back() {
        if (browser.getHistory().getBack().empty()) {
            System.out.println("You cant go back");
        } else {
            browser.getHistory().getForward().push(browser.saveMemento());
            browser.getHistory().getBack().pop().createFromSnapshot(browser);
        }
    }

    public void forward(){
        if (browser.getHistory().getForward().empty()){
            System.out.println("You cant go forward");
        } else {
            browser.getHistory().getBack().push(browser.saveMemento());
            browser.getHistory().getForward().pop().createFromSnapshot(browser);
        }
    }

    public void goToPosition(int position){
            browser.getCurrentPage().setPosition(position);
    }

    public void goToAdv(){



    }



}
