package browser;

public class TextPage extends Page {

    private int advPosition;


    public TextPage(String url, int advPosition) {
        super(url);
        this.advPosition = advPosition;
    }


    @Override
    void goToPosition(int position, Browser browser) {
        this.position = position;
    }

    @Override
    void goToAdv(Browser browser) {
        if(position == advPosition){
            browser.setCurrentPage(new AdvPage("advPage"));
        }
        System.out.println("you linked to adv page");
    }
}
