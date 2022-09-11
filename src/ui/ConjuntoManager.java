package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;

@SuppressWarnings({"unchecked", "removal"})
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
                "\n\n----------------------\n"+
                "|    Menu Inicial    |\n"+
                "----------------------\n\n"+
				"Seleccione una opcion\n" +
				"(1) Agregar Elemento\n" +
				"(2) Union\n" +
                "(3) Interseccion\n" +
				"(4) Buscar\n" +
                "(5) Eliminar\n" +
				"(6) Mostrar Conjuntos\n" +
                "(0) Para Salir\n\n"
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

		int selectedArray;

		do{System.out.println(
                "\n\n----------------------\n"+
                "|    Menu Arreglos   |\n"+
                "----------------------\n\n"+
				"Seleccione un arreglo\n" +
				"(1) "+ints.toString()+"\n\n" +
				"(2) "+ints2.toString()+"\n\n" +
                "(3) "+str.toString()+"\n\n" +
				"(4) "+str2.toString()+"\n\n" +
                "(5) "+chr.toString()+"\n\n" +
				"(6) "+chr2.toString()+"\n\n" +
                "(0) Para regresar al menu principal\n\n"
				);
                selectedArray= sc.nextInt();
		    sc.nextLine();
  
        }while(selectedArray<0||selectedArray>6);
        
        int second=0;

        if(option==2||option==3){

            if(selectedArray==1||selectedArray==2){

                do{System.out.println(
                    "\n\nSeleccione un segundo arreglo del mismo tipo:\n" +
                    "(1) "+ints.toString()+"\n\n" +
                    "(2) "+ints2.toString()+"\n\n"
                    );
                    second = sc.nextInt();
                    sc.nextLine();
                
                }while(second!=1&&second!=2);

            }

            if(selectedArray==3||selectedArray==4){

                do{System.out.println(
                    "\n\nSeleccione un segundo arreglo del mismo tipo:\n" +
                    "(3) "+str.toString()+"\n\n" +
                    "(4) "+str2.toString()+"\n\n"
                    );
                    second = sc.nextInt();
                    sc.nextLine();
                
                }while(second!=3&&second!=4);
                
            }

            if(selectedArray==5||selectedArray==6){

                do{System.out.println(
                    "\n\nSeleccione un segundo arreglo del mismo tipo:\n" +
                    "(5) "+chr.toString()+"\n\n" +
                    "(6) "+chr2.toString()+"\n\n"
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
            System.out.println("\n\nResultado:\n\n"+toChange.toString());
			break;
		case 2:
            union(toChange, toUse);
            System.out.println("\n\nResultado:\n\n"+toChange.toString());
			break;
        case 3:
            interseccion(toChange, toUse);
            System.out.println("\n\nResultado:\n\n"+toChange.toString());
            break;
        case 4:
            buscar(toChange);
            break;
        case 5:
            eliminar(toChange);
            System.out.println("\n\nResultado:\n\n"+toChange.toString());
            break;
        case 6:
            System.out.println(toPrint());
            break;
		default:
			System.out.println("Error, opción no válida");
		    break;

		}
	}

    public <T> void agregar(Conjunto<T> toChange){
        boolean n = true;
        T holder = null;
        while(n){
            System.out.println("\nIngrese el valor" + " "+ toChange.getArrayList().get(0).getClass().getSimpleName() + "\n");
            if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Integer")){
                try{
                    holder = (T)new Integer(sc.nextInt());
                    n = false;
                }
                catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Character")){
                try{
                    holder = (T)new Character(sc.next().charAt(0));
                    n = false;
                }
                catch (InputMismatchException o){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().equals(String.class)){
                try{
                    holder = (T)sc.nextLine();
                    n = false;
                }
                catch (InputMismatchException i){
                    System.out.println("Invalid data input");
                
                }
            }
        }
        toChange.agregarElemento(holder);
    }



    public <T>void union(Conjunto<T> toChange, Conjunto<T> toUse){

        toChange.union(toUse);

    }

    public <T>void interseccion(Conjunto<T> toChange, Conjunto<T> toUse){

        toChange.interseccion(toUse);

    }

    public <T>void buscar(Conjunto<T> toChange){
        boolean n = true;
        T holder = null;
        while(n){
            System.out.println("\nIngrese el valor" + " "+ toChange.getArrayList().get(0).getClass().getSimpleName() + "\n");
            if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Integer")){
                try{
                    holder = (T)new Integer(sc.nextInt());
                    n = false;
                }
                catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Character")){
                try{
                    holder = (T)new Character(sc.next().charAt(0));
                    n = false;
                }
                catch (InputMismatchException o){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().equals(String.class)){
                try{
                    holder = (T)sc.nextLine();
                    n = false;
                }
                catch (InputMismatchException i){
                    System.out.println("Invalid data input");
                
                }
            }
        }

        if(toChange.buscar(holder)) System.out.println("el elemento se encuentra presente");
        else System.out.println("el elemento no se encuentra");
    }

    public <T>void eliminar(Conjunto<T> toChange){
        boolean n = true;
        T holder = null;
        while(n){
            System.out.println("\nIngrese el valor" + " "+ toChange.getArrayList().get(0).getClass().getSimpleName() + "\n");
            if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Integer")){
                try{
                    holder = (T)new Integer(sc.nextInt());
                    n = false;
                }
                catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().getSimpleName().equals("Character")){
                try{
                    holder = (T)new Character(sc.next().charAt(0));
                    n = false;
                }
                catch (InputMismatchException o){
                    sc.nextLine();
                    System.out.println("Invalid type");
                }
            }
            else if(toChange.getArrayList().get(0).getClass().equals(String.class)){
                try{
                    holder = (T)sc.nextLine();
                    n = false;
                }
                catch (InputMismatchException i){
                    System.out.println("Invalid data input");
                
                }
            }
        }

        if(toChange.eliminar(holder)) System.out.println("el elemento se ha eliminado");
        else System.out.println("el elemento no se encuentra");
    }

    public String toPrint(){

        String out="\n\nArreglo 1 "+ints.toString()+"\n\nArreglo 2 "+ints2.toString()
        +"\n\nArreglo 3 "+str.toString()+"\n\nArreglo 4 "+str2.toString()+"\n\nArreglo 5 "+chr.toString()+
        "\n\nArreglo 6 "+chr2.toString();
        
    
        return out;

    }

    public void init(){

        ints.agregarElemento(0);

        ints2.agregarElemento(1);
        ints2.agregarElemento(2);
        ints2.agregarElemento(3);
        ints2.agregarElemento(4);
        ints2.agregarElemento(5);
        ints2.agregarElemento(6);
        ints2.agregarElemento(7);
        ints2.agregarElemento(8);
        ints2.agregarElemento(9);

        str.agregarElemento("");
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

        chr.agregarElemento(' ');

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