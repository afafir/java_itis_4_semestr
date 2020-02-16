package iterators;

import model.Kladr;
import model.Node;
import util.PriorityComparator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IteratorBfsPriority implements Iterator {
    private Queue<Node> queue = new LinkedList<Node>();
    private Kladr kladr;

    public IteratorBfsPriority(Kladr kladr){
        this.kladr = kladr;
        queue.add(kladr.getRoot());
    }


    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Node next() {
        Node next = queue.poll();
        if (next.getChildren()!=null) {
            List<Node> priority = next.getChildren();
            priority.sort(Comparator.comparingInt(Node::getPriority));
            queue.addAll(priority);
        }
        return next;
    }

    @Override
    public Node getCurrent() {
        return null;
    }

    @Override
    public void reset() {

    }
}
