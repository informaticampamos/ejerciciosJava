/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenU7;

public class Participacion {
    private String dni;
    private String nombre;
    private int numeroPapeleta;
    private String emisora;

    public Participacion(String dni, String nombre, int numeroPapeleta, String emisora) {
        this.dni = dni;
        this.nombre = nombre;
        this.numeroPapeleta = numeroPapeleta;
        this.emisora = emisora;
    }
    
    /**
     * Falta definir un constructor con el atributo/s que determinemos que es diferenciador para la participación
     * @return 
     */
    public Participacion(int numeroPapeleta){
        this.numeroPapeleta = numeroPapeleta;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPapeleta() {
        return numeroPapeleta;
    }

    public String getEmisora() {
        return emisora;
    }

    /**
     * Falta definir el método equals con el atributo/s que determinemos que es diferenciador para la participación
     * @return 
     */
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
        final Participacion other = (Participacion) obj;
        return this.numeroPapeleta == other.numeroPapeleta;
    }

    @Override
    public String toString() {
        return "Participacion{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroPapeleta=" + numeroPapeleta +
                ", emisora=" + emisora +
                '}';
    }
}
