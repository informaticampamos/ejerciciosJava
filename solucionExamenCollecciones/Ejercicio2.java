/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner sc;
    static ArrayList<Empleado> empleados;
    static ArrayList<Empleado> jefes;

    public static void main(String[] args) {
        sc = new Scanner(System.in).useDelimiter("\n");
        empleados = new ArrayList<>();
        jefes = new ArrayList<>();
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir un empleado nuevo");
            System.out.println("2. Empleado a Jefe según DNI");
            System.out.println("3. Jefe a Empleado según DNI");
            System.out.println("4. Mostrar datos de todos los trabajadores");
            System.out.println("5. Eliminar definitivamente a un trabajador");
            System.out.println("6. Salir del programa");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    anadirEmpleado();
                    break;
                case 2:
                    empleadoAJefe();
                    break;
                case 3:
                    jefeAEmpleado();
                    break;
                case 4:
                    mostrarTodosTrabajadores();
                    break;
                case 5:
                    eliminarTrabajador();
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        sc.close();
    }

    public static void anadirEmpleado() {
        System.out.println("Introduzca los datos del empleado:");
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();

        empleados.add(new Empleado(dni, nombre, edad, sueldo));
        System.out.println("Empleado añadido correctamente.");
    }

    public static void empleadoAJefe() {
        System.out.print("DNI del empleado que desea cambiar a jefe: ");
        String dni = sc.next();
        if (empleados.contains(new Empleado(dni))){
            int indiceEmpleado = empleados.indexOf(new Empleado(dni));
            jefes.add(empleados.get(indiceEmpleado));
            empleados.remove(indiceEmpleado);
            System.out.println("Empleado cambiado a jefe correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con ese DNI.");
        }
    }

    public static void jefeAEmpleado() {
        System.out.print("DNI del jefe que desea cambiar a empleado: ");
        String dni = sc.next();
        if (jefes.contains(new Empleado(dni))){
            int indiceJefe = jefes.indexOf(new Empleado(dni));
            empleados.add(jefes.get(indiceJefe));
            jefes.remove(indiceJefe);
            System.out.println("Jefe cambiado a empleado correctamente.");
        } else {
            System.out.println("No se encontró ningún jefe con ese DNI.");
        }
    }

    private static void mostrarTodosTrabajadores() {
        System.out.println("------- Empleados --------------");
        if (empleados.isEmpty())
            System.out.println ("No existen empleados");
        else for (Empleado emp : empleados)
                System.out.println(emp);
        System.out.println("------- Jefes --------------");
        if (jefes.isEmpty())
            System.out.println ("No existen jefes");
        else for (Empleado jefe: jefes)
            System.out.println(jefe);
    }

    public static void eliminarTrabajador() {
        System.out.print("DNI del trabajador que desea eliminar: ");
        String dni = sc.next();

        Empleado trabajadorBorrar = new Empleado(dni);
        boolean esEmpleado = empleados.contains(trabajadorBorrar);
        boolean esJefe = jefes.contains(trabajadorBorrar);

        if (esEmpleado) {
            empleados.remove(trabajadorBorrar);
            System.out.println("Empleado eliminado correctamente.");
        } else if (esJefe) {
            jefes.remove(trabajadorBorrar);
            System.out.println("Jefe eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún trabajador con ese DNI.");
        }
    }
  
}