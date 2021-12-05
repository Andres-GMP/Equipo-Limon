package test;

import java.util.InputMismatchException;
import java.util.Scanner;

import arbolbinario.ArbolBinarios;


public class testOrdenamiento {
    
    public static void main(String[] args) throws Exception{

        Scanner lector = new Scanner(System.in);     
        int opcion;
        ArbolBinarios arbol = new ArbolBinarios();
        int elemento;
        String seguir;
        boolean salir = false;
        boolean verdad = false;

        
        while(!salir){

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t+--+---------MENU DE OPCIONES---------+");
            System.out.println("\t|1.| INSERTAR EL ARBOL BINARIO        |");
            System.out.println("\t|2.| BUSQUEDA BINARIA (ARBOL)         |");
            System.out.println("\t|3.| ARBOLES BINARIO ORDENADO         |");
            System.out.println("\t|4.| SALIR DEL SISTEMA                |");
            System.out.println("\t+--+----------------------------------+");
            System.out.println("\t|        SELECCIONA UNA OPCION        |");
            System.out.println("\t+--+----------------------------------+");

            try{
                opcion = lector.nextInt();

         
        switch(opcion)
        {
            case 1:
                do{
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t       INGRESA EL NUMERO DEL NODO      ");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                elemento = lector.nextInt();
                arbol.agregarNodo(elemento);

                System.out.println("\t DESEAS SEGUIR INSERTANDO?  (SI/NO) ");
                seguir = lector.next();
                }while(seguir.equals("SI"));

            break;

            case 2:
            if (!arbol.esVacio()){
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t  INGRESA EL NUMERO DEL NODO A BUSCAR  ");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                elemento = lector.nextInt();

                if (arbol.buscarNodo(elemento) == null){
                    System.out.println("\t NODO NO ENCONTRADO ");
                }
                else
                {
                    System.out.println("\t NODO ENCONTRADO " + arbol.buscarNodo(elemento));
                }
            }
                
            break;

            case 3:
            int opciones;
            do{
            System.out.println("\n\n\t+--+----------ORDENAMIENTO------------+");
            System.out.println("\t|1.| ORDENAMIENTO INORDEN             |");
            System.out.println("\t|2.| ORDENAMIENTO POSTORDEN           |");
            System.out.println("\t|3.| ORDENAMIENTO PREORDEN            |");
            System.out.println("\t|4.| REGRESAR AL MENU PRINCIPAL       |");
            System.out.println("\t+--+----------------------------------+");
            System.out.println("\t|        SELECCIONA UNA OPCION        |");
            System.out.println("\t+--+----------------------------------+");

            opciones = lector.nextInt();
            switch(opciones)
            {

                case 1:
                //ARBOL INORDEN
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t    ARBOL ORDENADO POR INORDEN     ");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (!arbol.esVacio()){
                    arbol.inOrden(arbol.raiz);
                }
                else{
                    System.out.println("\tEL ARBOL ESTA VACIO");
                }
                break;
            
                case 2:
                //ARBOL POSTORDEN
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t   ARBOL ORDENADO POR POSTORDEN    ");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (!arbol.esVacio()){
                    arbol.postOrden(arbol.raiz);
                }
                else{
                    System.out.println("\tEL ARBOL ESTA VACIO");
                }
                break;
                
                case 3:
                //ARBOL PREORDEN
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t    ARBOL ORDENADO POR PREORDEN    ");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (!arbol.esVacio()){
                    arbol.preOrden(arbol.raiz);
                }
                else{
                    System.out.println("\tEL ARBOL ESTA VACIO");
                }
                break;

                case 4:
                System.out.println("\tREGRESANDO AL MENU PRINCIPAL");
                verdad = true;
                break;

                default:
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t|        NO EXISTE ESTA OPCION        |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                break;

            }
        }while(verdad == false);
        break;

            case 4:
            salir = true;
            break;

            default:
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t|        NO EXISTE ESTA OPCION        |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                break;
            }

        }
        catch(InputMismatchException e ){
            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t|     DEBES DE INTRODUCIR UN NUMERO   |");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            lector.next();

        }

            

            }
        }
    }



