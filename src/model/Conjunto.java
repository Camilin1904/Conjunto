package model;

import java.util.ArrayList;

public class Conjunto <T> {
    ArrayList<T> elements;

    public Conjunto(){

        elements = new ArrayList<>();

    }


    public boolean agregarElemento(T elemento){

        if(elements.contains(' ')||elements.contains("")) elements.set(0, elemento);

        if (!elements.contains(elemento)) elements.add(elemento);
        else return false;
        return true;
    }

    public void union(Conjunto<T> otros){
        for (int i=0; i<otros.getArrayList().size(); i++){
            agregarElemento(otros.getArrayList().get(i));
        }
    }

    public void interseccion(Conjunto<T> otros){
        elements.retainAll(otros.getArrayList());
    }

    public boolean buscar(T elemento){
        return elements.contains(elemento);
    }

    public boolean eliminar(T elemento){
        return elements.remove(elemento);
    }

    public String toString(){

        String out=" Tipo "+ elements.get(0).getClass().getSimpleName() +"\n        {";

        for(int i=0; i<elements.size();i++){

            out+=elements.get(i);

            if(i<elements.size()-1&&elements.get(i+1)!=null){

                out+=" , ";

            }

        }

        out+="}";

        return out;

    }



    public ArrayList<T> getArrayList(){

        return elements;

    }

    public T getElement(int index){
        return elements.get(index);
    }

    public int size(){
        return elements.size();
    }
}
