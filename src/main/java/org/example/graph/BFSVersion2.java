package org.example.graph;

import java.util.*;

public class BFSVersion2 {
    public static<T> Optional<Node<T>> search (T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();//frontera
        start.setPathDefault();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        while (!queue.isEmpty()){//1. Verificar si puedo continuar
            currentNode = queue.remove();
            System.out.println("Visitando el nodo " + currentNode.getValue());

            //2. Verificar si se encuentra en la meta
            if (currentNode.getValue().equals(value)){
                System.out.println("La ruta a seguir es: " + currentNode.getPath());
                return Optional.of(currentNode);
            }else{
                if (!closed.contains(currentNode)){
                    closed.add(currentNode);//añadir al espacio explorado
                    for (var neighbor: currentNode.getNeighbors()){
                        neighbor.setPathDefault();
                        neighbor.saveParentPath(currentNode);
                    }
                    queue.addAll(currentNode.getNeighbors());
                    queue.removeAll(closed);
                }
            }


        }

        return Optional.empty();//no se encontró ninguna solución, nodo vacío
    }
}
