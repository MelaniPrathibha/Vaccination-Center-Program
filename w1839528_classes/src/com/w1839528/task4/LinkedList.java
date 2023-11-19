package com.w1839528.task4;

public class LinkedList<Type> {
    private Node<Type> head;

    //sed head link to null
    public LinkedList() {
        this.head = null;
    }

    //Check whether linked list is empty or not
    public boolean empty(){
        return head == null;
    }

    //add data to the last index of the linked list
    public void insertData(Type data){
        if (empty()){
            Node<Type> node = new Node<>(data,head);
            head = node;
        }
        else {
            Node<Type> current = head;

            while (current.getLink() != null){
                current = current.getLink();
            }

            Node<Type> node = new Node<>(data, null);
            current.setLink(node);

        }
    }

    //delete data at the head of the linked list
    public Type deleteAtHead(){

        Node<Type> deletedNode = head;
        head = head.getLink();

        return  deletedNode.getData();
    }

    //get data at the head position
    public Type getData(){
        if (empty()){
            System.out.println("The Queue is empty . . .");
        }
        Node<Type> current = head;

        return current.getData();
    }

}
