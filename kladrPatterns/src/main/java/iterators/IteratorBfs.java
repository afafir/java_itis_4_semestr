package iterators;


import model.Kladr;
import model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorBfs implements Iterator<Node> {
    private Queue<Node> queue = new LinkedList<Node>();
    private Node root;


    public IteratorBfs(Node root){
        queue.add(root);
    }


    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Node next() {
        Node next = queue.poll();
        if (next.getChildren()!=null) {
            queue.addAll(next.getChildren());
        }
        return next;
    }

    public Node getCurrent() {
        return queue.peek();
    }

    public void reset() {
        queue = new LinkedList<Node>();
        queue.add(root);
    }

}
