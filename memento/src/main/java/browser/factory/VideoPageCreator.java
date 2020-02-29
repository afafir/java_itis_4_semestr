package browser.factory;

import browser.Page;
import browser.VideoPage;

public class VideoPageCreator extends PageCreator {
    @Override
    public Page pageCreator(Object... params) {
        return  new VideoPage((String) params[0]);
    }
}
