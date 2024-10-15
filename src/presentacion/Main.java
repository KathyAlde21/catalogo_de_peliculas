package presentacion;

import dominio.Pelicula;
import java.util.Scanner;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivos;
import servicio.ServicioPeliculasLista;

public class Main {
    
    public static void main(String[] args) {
            
        boolean salir = false;
        Scanner input = new Scanner(System.in);
        
      //  IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivos();
        
        while (!salir) {
            try {
                mostrarMenu();                
                salir = ejecutarOpciones(input, servicioPeliculas);
                
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
            }
        }    
    }
    /**
     * Creando Menu
     */
    private static void mostrarMenu() { //""" permite anotar hacia abajo como texto
        System.out.println("""
                           *** Catalogo de Peliculas ***
                           1. Agregar Pelicula
                           2. Lista de Peliculas
                           3. Buscar Pelicula
                           4. Salir
                           Elije una opcion
                           """);
    }

    public static boolean ejecutarOpciones(Scanner input, IServicioPeliculas servicioPeliculas) {
        
        int opcion = Integer.parseInt(input.nextLine());
        boolean salir = false;
        
        switch (opcion) {
            case 1 -> { //Agregar Pelicula
                System.out.println("Introduce el nombre de la pelicula");
                String nombrePelicula = input.nextLine();
                //opcion 1 de escribir
               /* Pelicula nuevaPelicula = new Pelicula(nombrePelicula);
                servicioPeliculas.agregarPelicula(nuevaPelicula)); */
                //opcion 2 en 1 sola linea
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> //Lista de Peliculas
                servicioPeliculas.listarPeliculas();                
            
            case 3 -> { //Buscar Pelicula
                System.out.println("Introduce la pelicula que quieres buscar");
                String buscar = input.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> { //Salir
                System.out.println("Hasta pronto!!");
                salir = true;
            }
            default -> { //en caso que ingresen dato incorrecto
                System.out.println("La opcion ingresada no es valida");
            }
        }
        return salir;
    }

    

    
    
}
