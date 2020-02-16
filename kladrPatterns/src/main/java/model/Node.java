package model;

import com.fasterxml.jackson.annotation.*;
import iterators.Iterator;
import iterators.IteratorBfs;
import iterators.IteratorBfsPriority;
import iterators.IteratorDfs;
import util.Type;

import java.security.PublicKey;
import java.util.List;

public class Node{
    private String name;
    private Type type;
    private int priority;
    private List<Node> children;
    @JsonIgnore
    private Node parent;


    public Node(){

    }


    public Node(String name, Type type, int priority){
        this.name = name;
        this.type = type;
        this.priority = priority;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public static Builder getBuilder(){
        return new Node().new Builder();
    }

    public Iterator bfsIterator() {
        return new IteratorBfs(this);
    }

    public Iterator dfsIterator(){
        return new IteratorDfs(this);
    }


    public class Builder{
        private Builder(){
        }


        public Builder setName(String name){
            Node.this.name = name;
            return this;
        }

        public Builder setType(Type type){
            Node.this.type = type;
            return this;
        }

        public Builder setPriority(int priority){
            Node.this.priority = priority;
            return this;
        }

        public Builder setChildren(List<Node> children){
            Node.this.children = children;
            return this;
        }

        public Builder setParent(Node parent){
            Node.this.parent = parent;
            return this;
        }

        public Node build(){
            return Node.this;
        }

    }



    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                '}';
    }
}
