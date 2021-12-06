package trabajadores;

import java.util.ArrayList;

import java.util.Random;

public class Trabajador extends Persona{
    //variables
    public int id;
    public double sueldo;
    public String puesto;

    public static ArrayList<Integer> array = new ArrayList<Integer>();//guarda datos para no repetirlos

    //metodo para que el id que sea creado no este repetido
    public static int metodoId(){

        Random numero = new Random();//generar aleatorio
        int aleatorio = 1000 + numero.nextInt(8999);//generar numero aleatorio entre 1000 y 9999
        
        //si ya existe el numero lo volvera a generar hasta que no este repetido
        while(array.contains(aleatorio)){
            aleatorio = 1000 + numero.nextInt(8999);
        }
        array.add(aleatorio);
        return aleatorio;
        //se guardara y regresara el valor que se logro conseguir
    }

    //constructor
    public Trabajador(String nombre, String aPaterno, String aMaterno, int edad, String genero, double sueldo,
            String puesto) {
        super(nombre, aPaterno, aMaterno, edad, genero);
        this.id = metodoId();//operacion para obtener un numero aleatorio
        this.sueldo = sueldo;
        this.puesto = puesto;
    }

    

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    //convertir a string
    
    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + "\nApellidos: "+ this.getaPaterno() + " " +this.getaMaterno()+ "\nEdad: " +
        this.getEdad() + "\nGenero: "+ this.getGenero() + "\nId:" + this.getId() + "\nSueldo: " + this.getSueldo() + 
        "\nPuesto: " + this.getPuesto() + "\n";
    }
    
}