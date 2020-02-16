package iterators;

import model.Kladr;
import model.Node;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class IteratorDfs implements Iterator {

    private Stack<Node> stack;


    public IteratorDfs(Node root){
        stack = new Stack<>();
        stack.add(root);
    }

    public boolean hasNext() {
        return stack.size()!=0;
    }

    public Node next(){
        if (!hasNext()){
            throw new NoSuchElementException("tree ran out");
        }
        Node node = stack.pop();
        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return node;
    }

    public Node getCurrent() {
        return  stack.peek();
    }

    public void reset() {

    }
}
