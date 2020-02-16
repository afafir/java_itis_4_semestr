package model;

import iterators.IteratorBfs;

import iterators.Iterator;
import iterators.IteratorBfsPriority;
import iterators.IteratorDfs;

public class Kladr{
    Node root;

    public Kladr(){

    }

    public Kladr(Node root) {
        this.root = root;
    }



    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }



    public Iterator bdsPriorityIterator(){
        return new IteratorBfsPriority(this);
    }
}
