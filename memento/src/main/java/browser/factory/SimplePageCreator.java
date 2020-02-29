package browser.factory;

import browser.Page;
import browser.SimplePage;

public class SimplePageCreator extends PageCreator{


    @Override
    public Page pageCreator(Object... params) {
        return new SimplePage((String) params[0]);
    }
}
