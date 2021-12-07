package limonproject;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import ABB.*;
import limonproject.ABB.ArbolBinario;
import limonproject.ABB.Nodo;

public class Trabajadores {

    public static void main(String[] args) throws Exception {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> idList = new ArrayList<Integer>();
        ArbolBinario arbolTrabajadores = new ArbolBinario();

        int opcion;
        boolean salir = false;

        while (!salir) {

            System.out.println("\n\t+--+------MENU DE OPCIONES------------+");
            System.out.println("\t|1.| DAR DE ALTA  (TRABAJADOR)        |");
            System.out.println("\t|2.| DAR DE BAJA  (TRABAJADOR)        |");
            System.out.println("\t|3.| CONSULTAS EMPLEADO  (POR ID)     |");
            System.out.println("\t|4.| MODIFICAR UN TRABAJADOR          |");
            System.out.println("\t|5.| SALIR DEL SISTEMA                |");
            System.out.println("\t+--+----------------------------------+");

            try {
                System.out.println("\t|        SELECCIONA UNA OPCION        |");
                System.out.println("\t+--+----------------------------------+");
                opcion = Integer.parseInt(lector.readLine());
                switch (opcion) {

                    // CASO #1 DAR DE ALTA AL TRABAJADOR
                    case 1:

                        // AUTOGENERAR ID
                        Random aleatorio = new Random();
                        int id = 1000 + aleatorio.nextInt(8999);

                        // PREGUNTA SI LA ID ESTA REPETIDO EN EL ARRAY
                        while (idList.contains(id)) {
                            id = 1000 + aleatorio.nextInt(8999);

                        }
                        // SI EN LA LISTA NO CONTIENE EL ID SE AGREGA ESTE
                        idList.add(id);

                        try {

                            System.out.println("\n\tINTRODUCIR TU NOMBRE");
                            String nom = lector.readLine();

                            System.out.println("\tINTRODUCIR TU APELLIDO PATERNO");
                            String apeP = lector.readLine();

                            System.out.println("\tINTRODUCIR TU APELLIDO MATERNO");
                            String apeM = lector.readLine();

                            System.out.println("\tINTRODUCIR TU EDAD");
                            int edad = Integer.parseInt(lector.readLine());

                            System.out.println("\tINTRODUCIR TU GENERO");
                            String gene = lector.readLine();

                            System.out.println("\tINTRODUCIR TU SUELDO");
                            int suel = Integer.parseInt(lector.readLine());

                            System.out.println("\tINTRODUCIR TU PUESTO");
                            String pues = lector.readLine();

                            // INSERTAMOS AL ARBOL UN NUEVO TRABAJADOR
                            arbolTrabajadores.agregarNodo(new Trabajador(nom, apeP, apeM, edad, gene, id, suel, pues));
                            System.out.println("\tHAS INSERTADO CORRECTAMENTE");

                        } catch (InputMismatchException e) {
                            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            lector.readLine();
                        }

                        break;

                    // CASO #2 DAR DE BAJA AL TRABAJADOR
                    case 2:

                        System.out.println("\n\tINTRODUCE EL ID DEL TRABAJADOR A ELIMINAR (4 DIGITOS)");
                        int ide = Integer.parseInt(lector.readLine());

                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\tESTAS SEGURO DE ELIMINAR AL TRABAJADOR ? (SI/NO)");
                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        String opciones = lector.readLine();
                        

                        try {
                            if (opciones.equals("SI")) {
                                 arbolTrabajadores.eliminarNodo(ide);
                                 
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|   SE HA ELIMINADO CORRECTAMENTE     |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            } else if (opciones.equals("NO")) {
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|      SE HA SALIDO DEL SISTEMA       |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            } else {
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            }
                        } catch (Exception e) {
                            System.out.println("\n\t NO EXISTE EL ID DEL TRABAJADOR ");
                        }
                        break;

                    // CASO #3 MOSTRAMOS EL ARBOL DE LOS TRABAJADORES INSERTADOS
                    case 3:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;

                    // CASO #4 MODIFICACION A LOS DATOS DE LOS TRABAJADORES
                    case 4:
                        try {
                            System.out.println("\n\tINTRODUCE EL ID DEL TRABAJADOR A MODIFICAR (4 DIGITOS)");
                            ide = Integer.parseInt(lector.readLine());

                            // listaTrabajadores.modificar(ide);
                        } catch (Exception e) {
                            System.out.println("\n\t NO EXISTE EL ID DEL TRABAJADOR ");
                        }
                        break;

                    // CASO #5 CERRAR EL PROGRAMA
                    case 5:
                        salir = true;
                        break;

                    default:
                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                }

            } catch (InputMismatchException e) {
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t|     DEBES DE INTRODUCIR UN NUMERO   |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                lector.readLine();

            }

        }

        System.out.println("xd");

    }

    //METODO PARA MODIFICAR
    public void modificar(int id) throws Exception{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Nodo actual = arbolTrabajadores.busqueda(id);
        System.out.println("¿DESEA MODIFICAR TODOS LOS DATOS O SOLO UN CAMPO?");
        int res = Integer.parseInt(lector.readLine());
        System.out.println("\t+--+---------------------+");
        System.out.println("\t|1.| TODOS LOS DATOS     |");
        System.out.println("\t|2.| CAMPO EN ESPECIFICO |");
        System.out.println("\t|3.| CANCELAR            |"); 
        System.out.println("\t+--+---------------------+"); 
        switch (res) {
            case 1:
            try {
                System.out.println("\n\tINTRODUCIR TU NOMBRE");
                String nom = lector.readLine();

                System.out.println("\tINTRODUCIR TU APELLIDO PATERNO");
                String apeP = lector.readLine();

                System.out.println("\tINTRODUCIR TU APELLIDO MATERNO");
                String apeM = lector.readLine();

                System.out.println("\tINTRODUCIR TU EDAD");
                int edad = Integer.parseInt(lector.readLine());

                System.out.println("\tINTRODUCIR TU GENERO");
                String gene = lector.readLine();

                System.out.println("\tINTRODUCIR TU SUELDO");
                int suel = Integer.parseInt(lector.readLine());

                System.out.println("\tINTRODUCIR TU PUESTO");
                String pues = lector.readLine();

                // INSERTAMOS AL ARBOL LA INFORMACIÓN ACTUALIZADA DE UN TRABAJADOR
                actual.nuevoValor(new Trabajador(nom, apeP, apeM, edad, gene, id, suel, pues));
                arbolTrabajadores.modificar(id, actual);
                System.out.println("\tDATOS MODIFICADOS CORRECTAMENTE");

            } catch (InputMismatchException e) {
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                lector.readLine();
            }
                break;
            case 2:
            boolean encontrado;
            encontrado = false;

                encontrado = (Trabajador(actual.valorNodo())).getId() == id;
                if(encontrado)
                {
                    System.out.println("\tQUE APARTADO DESEAS MODIFICAR?");
                    System.out.println("\t+--+------------+");
                    System.out.println("\t|1.| NOMBRE     |");
                    System.out.println("\t|2.| APELLIDO P |");
                    System.out.println("\t|3.| APELLIDO M |");
                    System.out.println("\t|4.| EDAD       |");
                    System.out.println("\t|5.| GENERO     |");
                    System.out.println("\t|6.| SUELDO     |");
                    System.out.println("\t|7.| PUESTO     |");
                    System.out.println("\t+--+------------+");
    
                    
                    try{
                            int opciones = Integer.parseInt(lector.readLine());
                              
                            switch(opciones){
                                case 1:
                                System.out.println("\n\tMODIFICA TU NOMBRE");
                                String nom  = lector.readLine();
                                (arbolTrabajadores.busqueda(id).getData()).setNombre(nom);
                                // ((Trabajador) actual.getData()).setNombre(nom);
                
                                break;
                                
                                case 2:
                                System.out.println("\tMODIFICA TU APELLIDO PATERNO");
                                String apeP  = lector.readLine();
                                ((Trabajador) actual.getData()).setApellidoP(apeP);
                                break;
    
                                case 3:
                                System.out.println("\tMODIFICA TU APELLIDO MATERNO");
                                String apeM  = lector.readLine();
                                ((Trabajador) actual.getData()).setApellidoM(apeM);
                                break;
    
                                case 4:
                                System.out.println("\tMODIFICA TU EDAD");
                                int edad = Integer.parseInt(lector.readLine());
                                ((Trabajador) actual.getData()).setEdad(edad);
                                break;
    
                                case 5:
                                System.out.println("\tMODIFICA TU GENERO");
                                String gene = lector.readLine();
                                ((Trabajador) actual.getData()).setGenero(gene);
                                break;
    
                                case 6:
                                System.out.println("\tMODIFICA TU SUELDO");
                                double suel = Double.parseDouble(lector.readLine());
                                ((Trabajador) actual.getData()).setSueldo(suel);
                                break;
    
                                case 7:
                                System.out.println("\tMODIFICA TU PUESTO");
                                String pues = lector.readLine();
                                ((Trabajador) actual.getData()).setPuesto(pues);
                                break;
    
                                default:
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    
                        }
                        
    
                    }catch(InputMismatchException e ){
                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        lector.readLine();
                        }
                        break;
                 }
                break;
        
            default:
            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                break;
        }
    }
}