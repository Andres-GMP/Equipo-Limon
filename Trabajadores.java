package limonproject;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import ABB.*;
import limonproject.ABB.ArbolBinario;

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
            System.out.println("\t|5.| ELIMINAR UN TRABAJADOR           |");
            System.out.println("\t|6.| SALIR DEL SISTEMA                |");
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

                            System.out.println("\tINTRODUCIR TU GENERO (M/F)");
                            String gene = lector.readLine();

                            System.out.println("\tINTRODUCIR TU SUELDO");
                            int suel = Integer.parseInt(lector.readLine());

                            System.out.println("\tINTRODUCIR TU PUESTO");
                            String pues = lector.readLine();

                            // INSERTAMOS A LA LISTA UN NUEVO TRABAJADOR
                            // String nombre, String apellidoPaterno, String apellidoMaterno, int
                            // edad,String genero, String id, double sueldo, String puesto
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
                                // listaTrabajadores.eliminar(ide);
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

                    // CASO #3 MOSTRAMOS LA TABLA DE LOS TRABAJADORES EN ORDE QUE LOS INSERTE
                    case 3:
                        System.out.println(
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                        System.out.println(
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;

                    // CASO #4 MOSTRAMOS LA TABLA DE LOS TRABAJADORES EN ORDEN ASCENDENTE POR ID
                    case 4:
                        System.out.println(
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES POR ID~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                        System.out.println(
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;

                    // CASO #5 MODIFICACION A LOS DATOS DE LOS TRABAJADORES
                    case 5:
                        try {
                            System.out.println("\n\tINTRODUCE EL ID DEL TRABAJADOR A MODIFICAR (4 DIGITOS)");
                            ide = Integer.parseInt(lector.readLine());

                            // listaTrabajadores.modificar(ide);
                        } catch (Exception e) {
                            System.out.println("\n\t NO EXISTE EL ID DEL TRABAJADOR ");
                        }
                        break;

                    case 6:
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

}
