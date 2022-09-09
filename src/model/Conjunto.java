package model;

import java.util.ArrayList;

public class Conjunto <T> {
    ArrayList<T> elements;

    public Conjunto(){

        elements = new ArrayList<>();

    }


    public boolean agregarElemento(T elemento){
        if (!elements.contains(elemento)) elements.add(elemento);
        else return false;
        return true;
    }

    public void union(ArrayList<T> otros){
        for (int i=0; i<otros.size(); i++){
            agregarElemento(otros.get(i));
        }
    }

    public void interseccion(ArrayList<T> otros){
        elements.retainAll(otros);
    }

    public boolean buscar(T elemento){
        return elements.contains(elemento);
    }

    public boolean eliminar(T elemento){
        return elements.remove(elemento);
    }
}
