package org.example.graph;

import java.util.*;

public class DFS {
    public static<T> Optional<Node<T>> search (T value, Node<T> start){
        Stack<Node<T>> stack = new Stack<>();//frontera
        start.setPathDefault();
        stack.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        while (!stack.isEmpty()){//1. Verificar si puedo continuar
            currentNode = stack.pop();
            System.out.println("Visitando el nodo " + currentNode.getValue());

            //2. Verificar si se encuentra en la meta
            if (currentNode.getValue().equals(value)){
                System.out.println("La ruta a seguir es: " + currentNode.getPath());
                return Optional.of(currentNode);
            }else{
                //if (!closed.contains(currentNode)) con la manipulación de colecciones no es necesario
                closed.add(currentNode);//añadir al espacio explorado
                for (var neighbor: currentNode.getNeighbors()){
                    neighbor.setPathDefault();
                    neighbor.saveParentPath(currentNode);
                }
                stack.addAll(currentNode.getNeighbors());
                stack.removeAll(closed);
            }


        }

        return Optional.empty();//no se encontró ninguna solución, nodo vacío
    }
}
