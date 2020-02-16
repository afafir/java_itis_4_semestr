package util;

import model.Node;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Node> {

    public int compare(Node o1, Node o2) {
        return o1.getPriority()-o2.getPriority();
    }
}
