package org.example.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;
    private String path;

    public Node(T value){
        this.value = value;
        this.neighbors = new HashSet<>();
        this.path = "";
    }

    public T getValue(){
        return this.value;
    }

    public Set<Node<T>> getNeighbors(){
        return Collections.unmodifiableSet(neighbors);
    }

    public void connect(Node<T> node){
        if (this == node)
            throw new IllegalArgumentException("Un nodo está intentando referenciarse a si mismo");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public String toString(){
        return this.value.toString();
    }

    public void saveParentPath(Node<T> parent){
        if (!parent.path.equals("")){
            this.path = parent.path + " -> " + this.toString();

        }
        else{
            //entonces es el primer nodo
            this.path = parent.toString() + " -> " + this.toString();
        }

    }

    public String getPath(){
        return this.path;
    }

    public void setPathDefault(){
        this.path = "";
    }



}
