package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasLista;

public class Main {
    
    public static void main(String[] args) {
        
       // System.out.println("Hola Mundo");
        
       /* ServicioPeliculasLista servicio1 = new ServicioPeliculasLista();
                
        Pelicula pelicula1 = new Pelicula();
        
        servicio1.agregarPelicula(pelicula1);
        
        System.out.println(servicio1);*/
        
        
            
        Pelicula pelicula1 = new Pelicula("Spiderman");
        
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
            
        servicioPeliculas.agregarPelicula(pelicula1);
        
        servicioPeliculas.listarPeliculas();      
    }
    
}
