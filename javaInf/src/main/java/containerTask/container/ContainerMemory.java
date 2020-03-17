package containerTask.container;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class ContainerMemory implements Container {
   private List<String> names;

   public ContainerMemory(){
       this.names = new ArrayList<String>();
   }

   public void add(String name){
       names.add(name);
   }



   public List<String> out(){
       return names;
   }

}
