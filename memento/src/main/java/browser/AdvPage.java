package browser;

class AdvPage extends Page {
    AdvPage(String url) {
        super(url);
    }

    @Override
    void goToPosition(int position, Browser browser) {

    }

    @Override
    void goToAdv(Browser browser) {
        System.out.println("u are already in adv Page");

    }
}
