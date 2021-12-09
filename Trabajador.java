package limonproject;

public class Trabajador extends Persona {
        private int id;
        private double sueldo;
        private String puesto;

        public Trabajador(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String genero,
                        int id, double sueldo, String puesto) {
                super(nombre, apellidoPaterno, apellidoMaterno, edad, genero);
                this.id = id;
                this.sueldo = sueldo;
                this.puesto = puesto;
        }

        public Trabajador() {
                this.id = "";
                this.sueldo = 0;
                this.puesto = "";
        }

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

        /**
         * Metodo para mostrar información del trabajador.
         */
        @Override
        public String toString() {
                // nombre, apellidoPaterno, apellidoMaterno, edad, genero, id, sueldo, puesto
                return getId() + "\t" + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + " ("
                                + getEdad() + ") " + getGenero() + "  $" + getSueldo() + " [" + getPuesto() + "]";
        }

        public Trabajador clone() {
                // String nombre, String apellidoPaterno, String apellidoMaterno, int edad,
                // String genero,
                // int id, double sueldo, String puesto
                return new Trabajador(this.getNombre(), this.getApellidoPaterno(), this.getApellidoMaterno(),
                                this.getEdad(), this.getGenero(), this.id, this.sueldo, this.puesto);
        }
}
