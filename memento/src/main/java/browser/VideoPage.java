package browser;

public class VideoPage extends Page {
    private int advPosition;

    public VideoPage(String url) {
        super(url);
    }

    @Override
    void goToPosition(int position, Browser browser) {
        this.position = position;
        if (position >= advPosition){
            goToAdv(browser);
        }
    }

    @Override
    void goToAdv(Browser browser) {
                if(position>=advPosition){
                    browser.setCurrentPage(new AdvPage("advPage"));
                }
        System.out.println("you linked to adv page");
    }
}
