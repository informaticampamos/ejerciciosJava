package examen;


public class Empleado {
    
    private String dni;
    private String nombre;
    private int edad;
    private double sueldo;
    
    public Empleado(String dni, String nombre, int edad, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
    
    public Empleado(String dni){
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado empleado = (Empleado) obj;
        return this.dni.equals(empleado.dni);
    }
    
    

}