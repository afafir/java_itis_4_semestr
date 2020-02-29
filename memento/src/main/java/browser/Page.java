package browser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.graalvm.compiler.asm.sparc.SPARCAssembler;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public abstract class Page {

   Integer position;
     String url;
    private List<Page> linkablePages;

   public Page(String url){
       this.url = url;
       position = 1;
   }
    abstract void goToPosition(int position, Browser browser);
   abstract void goToAdv(Browser browser);
}
