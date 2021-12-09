package limonproject;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import ABB.*;
import limonproject.ABB.ArbolBinario;
import limonproject.ABB.Nodo;

public class Trabajadores {
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    static ArbolBinario arbolTrabajadores = new ArbolBinario();

    public static void main(String[] args) throws Exception, IOException {

        ArrayList<Integer> idList = new ArrayList<Integer>();
        arbolTrabajadores.agregarNodo(new Trabajador("nom", "apeP", "apeM", 13, "gene", 6, 78, "pues"));

        int ide = 0;
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
                            double suel = Double.parseDouble(lector.readLine());

                            System.out.println("\tINTRODUCIR TU PUESTO");
                            String pues = lector.readLine();

                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\tGENERANDO ID...");
                            System.out.println("\tEL ID ES: " + id + " DEL TRABAJADOR: " + nom);

                            // INSERTAMOS AL ARBOL UN NUEVO TRABAJADOR
                            arbolTrabajadores.agregarNodo(new Trabajador(nom, apeP, apeM, edad, gene, id, suel, pues));
                            System.out.println("\t---------------------------------------------");
                            System.out.println("\t          HAS INSERTADO CORRECTAMENTE        ");
                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                        } catch (InputMismatchException e) {
                            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            lector.readLine();
                        }

                        break;

                    // CASO #2 DAR DE BAJA AL TRABAJADOR
                    case 2:
                        boolean aux = true;
                        do {
                            if (!arbolTrabajadores.esVacio()) {
                                System.out.println("\n\tINTRODUCE EL ID DEL TRABAJADOR A ELIMINAR (4 DIGITOS)");
                                ide = Integer.parseInt(lector.readLine());

                                if (arbolTrabajadores.busqueda(ide) != null) {
                                    if (aux) {
                                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        System.out.println("\tESTAS SEGURO DE ELIMINAR AL TRABAJADOR ? (SI/NO)");
                                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        String opciones = lector.readLine();

                                        try {
                                            if (opciones.equalsIgnoreCase("SI")) {
                                                arbolTrabajadores.eliminarNodo(ide);

                                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                                System.out.println("\t|   SE HA ELIMINADO CORRECTAMENTE     |");
                                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                                System.out.println("\t|     Nueva lista de trabajadore:     |");
                                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                                arbolTrabajadores.inOrden();
                                                System.out.println();
                                                System.out.println("DESEA ELIMINAR LOS DATOS DE ALGUN OTRO TRABAJADOR");
                                                aux = respuesta();
                                            } else if (opciones.equalsIgnoreCase("NO")) {
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
                                    }
                                } else {
                                    System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("\t|   EL TRABAJADOR CON EL ID: " + ide + " NO EXISTE   |");
                                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                    aux = false;
                                }

                            } else {
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|   El arbol se encuentra vacio        |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                aux = false;
                            }
                        } while (aux);
                        break;

                    // CASO #3 MOSTRAMOS EL ARBOL DE LOS TRABAJADORES INSERTADOS
                    case 3:
                        try {
                            System.out.println("\n\t+--+---CONSULTA DE TRABAJADORES-------+");
                            System.out.println("\t|1.| CONSULTA POR INORDEN             |");
                            System.out.println("\t|2.| CONSULTA POR PREORDEN            |");
                            System.out.println("\t|3.| CONSULTA POR POSTORDEN           |");
                            System.out.println("\t|4.| REGRESAR AL MENU PRINCIPAL       |");
                            System.out.println("\t+--+----------------------------------+");

                            try {
                                System.out.println("\t|        SELECCIONA UNA OPCION        |");
                                System.out.println("\t+--+----------------------------------+");
                                opcion = Integer.parseInt(lector.readLine());

                                switch (opcion) {

                                    case 1:
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES POR INORDEN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        arbolTrabajadores.inOrden();
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        break;

                                    case 2:
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES POR PREORDEN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        arbolTrabajadores.preOrden();
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        break;

                                    case 3:
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CONSULTA DE TRABAJADORES POR POSTORDEN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        arbolTrabajadores.postOrden();
                                        System.out.println(
                                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        break;

                                    default:
                                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                        System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                lector.readLine();
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\t|     DEBES DE INTRODUCIR UN NUMERO   |");
                            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                            lector.readLine();
                        }

                        break;

                    // CASO #4 MODIFICACION A LOS DATOS DE LOS TRABAJADORES
                    case 4:
                        boolean condicion = true;
                        while (condicion) {
                            try {
                                System.out.println("\n\tINTRODUCE EL ID DEL TRABAJADOR A MODIFICAR (4 DIGITOS)");
                                ide = Integer.parseInt(lector.readLine());
                                if (arbolTrabajadores.busqueda(ide) != null) {
                                    editar(ide);
                                    System.out.println("DESEA MODIFICAR LOS DATOS DE ALGUN OTRO TRABAJADOR");
                                    condicion = respuesta();
                                } else {
                                    System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("\t|   EL TRABAJADOR CON EL ID: " + ide + " NO EXISTE   |");
                                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                    condicion = false;
                                }

                            } catch (Exception e) {
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\n\t NO EXISTE EL ID DEL TRABAJADOR ");
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            }
                        }
                        break;

                    // CASO #5 CERRAR EL PROGRAMA
                    case 5:
                        salir = true;
                        break;
                    case 6:
                        trabajdoresPrueba();
                        break;
                    default:
                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                }

            } catch (Exception e) {
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t|     DEBES DE INTRODUCIR UN NUMERO   |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                // lector.readLine();

            }

        }

    }

    // METODO PARA MODIFICAR
    public static void editar(int id) throws Exception {
        Nodo actual = arbolTrabajadores.busqueda(id);
        System.out.println("¿DESEA MODIFICAR TODOS LOS DATOS O SOLO UN CAMPO?");
        System.out.println("\t+--+---------------------+");
        System.out.println("\t|1.| TODOS LOS DATOS     |");
        System.out.println("\t|2.| CAMPO EN ESPECIFICO |");
        System.out.println("\t|3.| CANCELAR            |");
        System.out.println("\t+--+---------------------+");
        int res = Integer.parseInt(lector.readLine());
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
                    double suel = Double.parseDouble(lector.readLine());

                    System.out.println("\tINTRODUCIR TU PUESTO");
                    String pues = lector.readLine();

                    // INSERTAMOS AL ARBOL LA INFORMACIÓN ACTUALIZADA DE UN TRABAJADOR
                    arbolTrabajadores.modificar(id, new Trabajador(nom, apeP, apeM, edad, gene, id, suel, pues));

                    System.out.println("\tDATOS MODIFICADOS CORRECTAMENTE");

                } catch (InputMismatchException e) {
                    System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    lector.readLine();
                }
                break;

            case 2:
                boolean encontrado, si = true;
                encontrado = false;

                // while(si){
                encontrado = (actual.valorNodo()).getId() == id;

                if (encontrado) {
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

                    try {
                        int opciones = Integer.parseInt(lector.readLine());

                        switch (opciones) {
                            case 1:
                                System.out.println("\n\tMODIFICA TU NOMBRE");
                                String nom = lector.readLine();
                                (arbolTrabajadores.busqueda(id).valorNodo()).setNombre(nom);
                                break;

                            case 2:
                                System.out.println("\tMODIFICA TU APELLIDO PATERNO");
                                String apeP = lector.readLine();
                                (arbolTrabajadores.busqueda(id).valorNodo()).setApellidoPaterno(apeP);
                                break;

                            case 3:
                                System.out.println("\tMODIFICA TU APELLIDO MATERNO");
                                String apeM = lector.readLine();
                                (arbolTrabajadores.busqueda(id).valorNodo()).setApellidoMaterno(apeM);
                                break;

                            case 4:
                                System.out.println("\tMODIFICA TU EDAD");
                                int edad = Integer.parseInt(lector.readLine());
                                (arbolTrabajadores.busqueda(id).valorNodo()).setEdad(edad);
                                break;

                            case 5:
                                System.out.println("\tMODIFICA TU GENERO");
                                String gene = lector.readLine();
                                (arbolTrabajadores.busqueda(id).valorNodo()).setGenero(gene);
                                break;

                            case 6:
                                System.out.println("\tMODIFICA TU SUELDO");
                                double suel = Double.parseDouble(lector.readLine());
                                (arbolTrabajadores.busqueda(id).valorNodo()).setSueldo(suel);
                                break;

                            case 7:
                                System.out.println("\tMODIFICA TU PUESTO");
                                String pues = lector.readLine();
                                (arbolTrabajadores.busqueda(id).valorNodo()).setPuesto(pues);
                                break;

                            default:
                                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("\t|      ESTA OPCION NO ES VALIDA       |");
                                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                        }

                    } catch (InputMismatchException e) {
                        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        lector.readLine();
                    }
                    break;
                }

                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("DESEA MODIFICAR OTRO DATO");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~\n");
                si = respuesta();
                // }
                break;

            case 3:

                break;

            default:
                System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t| DEBES DE INTRODUCIR DEL TIPO DE DATO QUE SE SOLICITA |");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                break;

        }

        // System.out.println("!");

    }

    public static boolean respuesta() throws IOException {
        System.out.println("\t+--+----+");
        System.out.println("\t|1.| SI |");
        System.out.println("\t|2.| NO |");
        System.out.println("\t+--+----+");
        String resp = lector.readLine();
        if (resp.equalsIgnoreCase("Si"))
            return true;
        else if (!resp.equalsIgnoreCase("No")) {
            return false;
        }
        System.out.println("(SI/NO)");
        lector.readLine();
        // respuesta();
        return false;
    }

    public static void trabajdoresPrueba() {
        arbolTrabajadores.agregarNodo(new Trabajador("AER", "E", "M", 19, "M", 10, 20, "ceo"));
        arbolTrabajadores.agregarNodo(new Trabajador("FZ", "E", "M", 19, "M", 9, 19, "ceo"));
        arbolTrabajadores.agregarNodo(new Trabajador("OGA", "E", "M", 19, "M", 11, 18, "ceo"));
        arbolTrabajadores.agregarNodo(new Trabajador("AER", "E", "M", 19, "M", 1, 18, "ceo"));
        System.out.println("hola");
    }

}