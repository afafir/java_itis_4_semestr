package browser;

import Momento.Memento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;
@Data
@AllArgsConstructor
@Builder

public class History {
    private Stack<Memento> forward;
    private Stack<Memento> back;

    History(){
        forward = new Stack<>();
        back = new Stack<>();
    }



    



}
