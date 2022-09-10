package ui;

import java.util.Scanner;

import javax.management.ObjectName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import model.Conjunto;

public class ConjuntoManager{

    private Scanner sc = new Scanner(System.in);
    private Conjunto<Integer> ints = new Conjunto<>();
    private Conjunto<String> str = new Conjunto<>();
    private Conjunto<Character> chr = new Conjunto<>();
    private Conjunto<Integer> ints2 = new Conjunto<>();
    private Conjunto<String> str2 = new Conjunto<>();
    private Conjunto<Character> chr2 = new Conjunto<>();

    public ConjuntoManager(){

    }
    public static void main(String[] args) {
        
        ConjuntoManager main = new ConjuntoManager();

        main.init();

        main.menu();

    }

    public void menu() {

		int option;

		do{System.out.println(
				"Seleccione una opcion\n" +
				"(1) Agregar Elemento\n" +
				"(2) Union\n" +
                "(3) Interseccion\n" +
				"(4) Buscar\n" +
                "(5) Eliminar\n" +
				"(6) Mostrar Conjuntos\n" +
                "(0) Para Salir"
				);
		    option= sc.nextInt();
		    sc.nextLine();

            if(option==6){
                executeOperation(option, null, null);
            }else if(option==0){

            }else{
                chooseTwoArray(option);
            }
        }while(option!=0);
	}

    public <T>void chooseTwoArray(int option) {

        System.out.println(toPrint());

		int selectedArray;

		do{System.out.println(
				"Seleccione un arreglo\n" +
				"(1)\n" +
				"(2)\n" +
                "(3)\n" +
				"(4)\n" +
                "(5)\n" +
				"(6)\n" +
                "(0) Para regresar al menu principal"
				);
                selectedArray= sc.nextInt();
		    sc.nextLine();
  
        }while(selectedArray<0||selectedArray>6);
        
        int second=0;

        if(option==2||option==3){

            if(selectedArray==1||selectedArray==2){

                do{System.out.println(
                    "Seleccione un segundo arreglo del mismo tipo:\n" +
                    "(1) \n" +
                    "(2) \n"
                    );
                    second = sc.nextInt();
                    sc.nextLine();
                
                }while(second!=1&&second!=2);

            }

            if(selectedArray==3||selectedArray==4){

                do{System.out.println(
                    "Seleccione un segundo arreglo del mismo tipo:\n" +
                    "(3) \n" +
                    "(4) \n"
                    );
                    second = sc.nextInt();
                    sc.nextLine();
                
                }while(second!=3&&second!=4);
                
            }

            if(selectedArray==5||selectedArray==6){

                do{System.out.println(
                    "Seleccione un segundo arreglo del mismo tipo:\n" +
                    "(5) \n" +
                    "(6) \n"
                    );
                    second = sc.nextInt();
                    sc.nextLine();
                
                }while(second!=5&&second!=6);
                
            }

            switch(selectedArray) {
                case 0:
                
                    break;
                case 1:
                    if(second==1){
                        executeOperation(option, ints, ints);
                    }else{
                        executeOperation(option, ints, ints2);
                    }
                    break;
                case 2:
                    if(second==1){
                        executeOperation(option, ints2, ints);
                    }else{
                        executeOperation(option, ints2, ints2);
                    }
                    break;
                case 3:
                    if(second==3){
                        executeOperation(option, str, str);
                    }else{
                        executeOperation(option, str, str2);
                    }
                    break;
                case 4:
                    if(second==3){
                        executeOperation(option, str2, str);
                    }else{
                        executeOperation(option, str2, str2);
                    }
                break;
                case 5:
                    if(second==5){
                        executeOperation(option, chr, chr);
                    }else{
                        executeOperation(option, chr, chr2);
                    }
                break;
                case 6:
                    if(second==5){
                        executeOperation(option, chr2, chr);
                    }else{
                        executeOperation(option, chr2, chr2);
                    }
                break;
                default:
                    System.out.println("Error, opción no válida");
                break;
            
            }

        }else{

            switch(selectedArray){
            case 0:

                break;
            case 1:
                executeOperation(option, ints, null);
                break;
            case 2:
                executeOperation(option, ints2, null);
                break;
            case 3:
                executeOperation(option, str, null);
                break;
            case 4:
                executeOperation(option, str2, null);
                break;
            case 5:
                executeOperation(option, chr, null);
                break;
            case 6:
                executeOperation(option, chr2, null);
                break;
            }

        }

	}

    public <T>void executeOperation(int option, Conjunto<T> toChange, Conjunto<T> toUse) {
		
        switch(option) {
		case 1:
            agregar(toChange);
            toChange.toString();
			break;
		case 2:
            union(toChange, toUse);
            toChange.toString();
			break;
        case 3:
            interseccion(toChange, toUse);
            toChange.toString();
            break;
        case 4:
            buscar(toChange);
            toChange.toString();
            break;
        case 5:
            eliminar(toChange);
            toChange.toString();
            break;
        case 6:
            toPrint();
            break;
		default:
			System.out.println("Error, opción no válida");
		    break;

		}
	}

    public <T> void agregar(Conjunto<T> toChange){



    }

    public <T>void union(Conjunto<T> toChange, Conjunto<T> toUse){

        toChange.union(toUse.getArrayList());

    }

    public <T>void interseccion(Conjunto<T> toChange, Conjunto<T> toUse){

        toChange.interseccion(toUse.getArrayList());

    }

    public <T>void buscar(Conjunto<T> toChange){

    }

    public <T>void eliminar(Conjunto<T> toChange){

    }

    public String toPrint(){

        String out="\n\nArreglo 1\n\n"+ints.toString()+"\n\nArreglo 2\n\n"+ints2.toString()
        +"\n\nArreglo 3\n\n"+str.toString()+"\n\nArreglo 4\n\n"+str2.toString()+"\n\nArreglo 5\n\n"+chr.toString()+
        "\n\nArreglo 6\n\n"+chr2.toString();
        
    
        return out;

    }

    public void init(){

        ints2.agregarElemento(1);
        ints2.agregarElemento(2);
        ints2.agregarElemento(3);
        ints2.agregarElemento(4);
        ints2.agregarElemento(5);
        ints2.agregarElemento(6);
        ints2.agregarElemento(7);
        ints2.agregarElemento(8);
        ints2.agregarElemento(9);

        str2.agregarElemento("Recursividad");
        str2.agregarElemento("Hola");
        str2.agregarElemento("Discretas");
        str2.agregarElemento("Java");
        str2.agregarElemento("Generics");
        str2.agregarElemento("Perro");
        str2.agregarElemento("Prueba");
        str2.agregarElemento("Algoritmo");
        str2.agregarElemento("Iteracion");

        String discretas = "DISCRETA";

        chr2.agregarElemento(discretas.charAt(0));
        chr2.agregarElemento(discretas.charAt(1));
        chr2.agregarElemento(discretas.charAt(2));
        chr2.agregarElemento(discretas.charAt(3));
        chr2.agregarElemento(discretas.charAt(4));
        chr2.agregarElemento(discretas.charAt(5));
        chr2.agregarElemento(discretas.charAt(6));
        chr2.agregarElemento(discretas.charAt(7));

    }
}