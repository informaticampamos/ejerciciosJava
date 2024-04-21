/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenU7;

import java.util.*;

public class Examen_U7 {
    private static final int NUMERO_PAPELETAS = 3;
    private static Scanner sc;
    private static List<Integer> numerosDisponibles = new ArrayList<>(); // listado de números a repartir
    private static Map<String, Integer> mapaParticipaciones = new HashMap<>(); // mapa con las participaciones de cada oyente 
    
    // Listas de participaciones para cada emisora
    private static List<Participacion> listaRadioMotril = new ArrayList<>();
    private static List<Participacion> listaMotrilOle = new ArrayList<>();
    private static List<Participacion> listaCasi100 = new ArrayList<>();
    
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        crearBarajarPapeletas();
        menu();
    }

    private static void crearBarajarPapeletas() {
        //Añadimos los números del 1 al 1000 a la lista, y luego la barajamos
        for (int i = 1; i <= NUMERO_PAPELETAS; i++) {
            numerosDisponibles.add(i);
        }
        Collections.shuffle(numerosDisponibles);
        System.out.println("Papeletas disponibles y barajadas: \n"+numerosDisponibles);
    }

    private static void menu() {
        int opcion;
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Añadir una nueva participación");
            System.out.println("2. Mostrar todas las participaciones de todas las emisoras");
            System.out.println("3. Mostrar participaciones por oyente");
            System.out.println("4. Mostrar el número de participantes únicos");
            System.out.println("5. Realizar sorteo");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    anadirParticipacion();
                    break;
                case 2:
                    mostrarTodasParticipaciones();
                    break;
                case 3:
                    mostrarParticipacionesPorOyente();
                    break;
                case 4:
                    participantesUnicos();
                    break;
                case 5:
                    realizarSorteo();
                    break;
                case 6:
                    System.out.println("SSalir");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }

    private static void anadirParticipacion() {
        System.out.print("DNI del oyente: ");
        String dni = sc.next();
        System.out.print("Nombre del oyente: ");
        String nombre = sc.next();
        System.out.println("\nEmisoras\n------------------------------");
        System.out.println("1. Radio Motril");
        System.out.println("2. Motril Ole");
        System.out.println("3. Cadena Casi 100 Motril");
        System.out.print("Elija una emisora para la participación: ");
        int opcionEmisora = sc.nextInt();
        
        int numeroPapeleta = numerosDisponibles.remove(0);
        
        Participacion participacion = null;
        switch (opcionEmisora) {
            case 1:
                participacion = new Participacion(dni, nombre, numeroPapeleta, "Radio Motril");
                listaRadioMotril.add(participacion);
                break;
            case 2:
                participacion = new Participacion(dni, nombre, numeroPapeleta, "Motril Ole");
                listaMotrilOle.add(participacion);
                break;
            case 3:
                participacion = new Participacion(dni, nombre, numeroPapeleta, "Cadena Casi 100 Motril");
                listaCasi100.add(participacion);
                break;
            default:
                System.out.println("Emisora no válida");
                return;
        }
        
        if (mapaParticipaciones.containsKey(dni))
            mapaParticipaciones.put(dni, mapaParticipaciones.get(dni) + 1);
        else mapaParticipaciones.put(dni, 1);
        
        System.out.println("Participación añadida.");
    }

    private static void mostrarTodasParticipaciones(){
        System.out.println(listaRadioMotril + "\n" + listaMotrilOle + "\n" + listaCasi100);
    }
    
    private static void mostrarParticipacionesPorOyente() {
        for (Map.Entry<String, Integer> entry : mapaParticipaciones.entrySet()) {
            System.out.println("Oyente: " + entry.getKey() + " tiene " + entry.getValue() + " participaciones en total");
        }
    }

    private static void participantesUnicos() {
        System.out.println("\nNúmero de participantes únicos: " + mapaParticipaciones.size());
    }

    private static void realizarSorteo() {
        int numeroGanador = (int) (Math.random() * NUMERO_PAPELETAS) + 1;
        System.out.println("\nNúmero ganador del sorteo: " + numeroGanador);
       
        Participacion auxParticipacion = new Participacion(numeroGanador);
        boolean estaRM = listaRadioMotril.contains(auxParticipacion);
        boolean estaMO = listaMotrilOle.contains(auxParticipacion);
        boolean estaCC = listaCasi100.contains(auxParticipacion);
        
        Participacion ganador = null;
        if (estaRM)
            ganador = listaRadioMotril.get(listaRadioMotril.indexOf(auxParticipacion));
        else if (estaMO)
            ganador = listaMotrilOle.get(listaMotrilOle.indexOf(auxParticipacion));
        else if (estaCC)
            ganador = listaCasi100.get(listaCasi100.indexOf(auxParticipacion));
        if (ganador != null){
            System.out.println("Ganador --> " + ganador.toString());
        }
        else {
            System.out.println("Premio desierto");
            mostrarTodasParticipaciones();
        }
    }
}