package com.w1839528.task4;


public class Node<Type> {
    private Type data;
    private Node link;

    //Node constructor
    public Node(Type data, Node<Type> link) {
        this.data = data;
        this.link = link;
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }

    public Node<Type> getLink() {
        return link;
    }

    public void setLink(Node<Type> link) {
        this.link = link;
    }
}
