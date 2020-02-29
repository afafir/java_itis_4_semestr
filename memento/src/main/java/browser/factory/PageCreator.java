package browser.factory;

import browser.Page;

public abstract class PageCreator{
    public abstract Page pageCreator(Object... params);
}
