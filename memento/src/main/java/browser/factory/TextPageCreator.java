package browser.factory;

import browser.Page;
import browser.TextPage;

public class TextPageCreator extends PageCreator {
    @Override
    public Page pageCreator(Object... params) {
        return new TextPage((String)params[0], (int)params[1]);
    }
}
