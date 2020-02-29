package browser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimplePage extends Page {


    public SimplePage(String url)
    {
        super(url);
    }

    @Override
    void goToPosition(int position, Browser browser) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "SimplePage{" +
                "url='" + url + '\'' +
                '}';
    }


    @Override
    void goToAdv(Browser browser) {
        System.out.println("here no adv");
    }
}
