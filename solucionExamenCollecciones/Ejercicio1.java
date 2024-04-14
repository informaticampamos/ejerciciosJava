/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;


class Instituto{
    Map<String,Integer> alumnos;
    public Instituto() {
        this.alumnos = new HashMap<>();
    }

    public void addAlumno(String nombreAlumno) {
        if (!alumnos.containsKey(nombreAlumno))
            alumnos.put(nombreAlumno,1);
        else alumnos.put(nombreAlumno, alumnos.get(nombreAlumno)+1);
    }

    public void mostrarTodos() {
        if (alumnos.isEmpty())
            System.out.println("No hay alumnos");
        else {
            for (Map.Entry<String, Integer> entrada : alumnos.entrySet()) {
                System.out.println("Nombre: " + entrada.getKey() + " : " + entrada.getValue());
            }
        }
    }

    public void borrarNombre(String nombre) {
        if (alumnos.containsKey(nombre))
            alumnos.remove(nombre);
        else System.out.println("No se ha encontrado a ningún alumno con el nombre " + nombre);
    }
    
    public TreeSet<String> crearConjuntoOrdenado() {
        return new TreeSet<>(alumnos.keySet());
    }
}
public class Ejercicio1 {
    static Scanner sc;
    static Instituto iesFJB;
    public static void main(String[] args) {
        iesFJB = new Instituto();
        sc = new Scanner(System.in).useDelimiter("\n");
        menu();
    }
    
    public static void menu() {
        int opcion;
        do {
            System.out.println("\n Menú \n_____________________________________");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Mostrar nombres y alumnos con dicho nombre");
            System.out.println("4. Crear conjunto ordenado de nombres de alumnos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            

            switch (opcion) {
                case 1:
                    anadirAlumno();
                    break;
                case 2:
                    eliminarNombre();
                    break;
                case 3:
                    iesFJB.mostrarTodos();
                    break;
                case 4:
                    crearConjuntoOrdenado();
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);

        sc.close();
    }

    private static void eliminarNombre() {
        System.out.print("Introduzca el nombre del alumno a eliminar: ");
        String nombreAlumno = sc.next();
        iesFJB.borrarNombre(nombreAlumno);
    }

    private static void anadirAlumno() {
        System.out.print("Introduzca el nombre del alumno: ");
        String nombreAlumno = sc.next();
        iesFJB.addAlumno(nombreAlumno);
    }

    private static void crearConjuntoOrdenado() {
        TreeSet<String> conjuntoOrdenado = iesFJB.crearConjuntoOrdenado();
        if (conjuntoOrdenado.isEmpty())
            System.out.println("No existen alumnos");
        else {
            System.out.println("Conjunto ordenado de nombres de alumnos:");
            System.out.println(conjuntoOrdenado);
        }
    }
}
