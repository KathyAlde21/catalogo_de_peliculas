package servicio;

import dominio.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivos implements IServicioPeliculas{

    //CREANDO ARCHIVO para almacenar la información
    
     private final String NOMBRE_ARCHIVO = "peliculas.txt";
     
     public ServicioPeliculasArchivos (){
         File archivo = new File(NOMBRE_ARCHIVO);
        
         try {
             if (archivo.exists()) {
             System.out.println("El archivo ya existe");
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("El archivo se creo correctamente");
            }
         } catch (Exception e) {
             System.out.println("Ocurrio un error: " + e.getMessage());
         }
         
     }
    
    //*****************
    //Metodos     
    @Override
    public void listarPeliculas() {
        
        File archivo = new File(NOMBRE_ARCHIVO); 
        
         try {
             System.out.println("--- Lista de Peliculas ---");
             
            //abrir archivo en modo lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //ejemplifica cada línea de nuestro texto
            String linea;
            linea = entrada.readLine(); //ve a leer la primera línea
            
            //con el ciclo ordeno la informacion que va a llegar a las líneas
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula.getNombre()); 
                //va a leer todas las líneas con texto
                linea = entrada.readLine();
            }
            entrada.close();
  
         } catch (Exception e) {
             System.out.println("Ocurrio un error: " + e.getMessage());
         }     
    }

    //--------------------------------------------------------------------------
    @Override
    public void agregarPelicula(Pelicula pelicula) {
        
        boolean agregar = false;
        File archivo = new File(NOMBRE_ARCHIVO); 
        
         try {
             agregar = archivo.exists();

             PrintWriter salida = new PrintWriter(new FileWriter(archivo, agregar));
             
             salida.println(pelicula.getNombre());
             salida.close();
             System.out.println("Se agrego la peliculicula: " + pelicula.getNombre());
            
         } catch (Exception e) {
             System.out.println("Ocurrio un error: " + e.getMessage());
         } 
    }
        
    //------------------------------------------------------------
    @Override
    public void buscarPelicula(Pelicula pelicula) {
        
         File archivo = new File(NOMBRE_ARCHIVO); 
        
         try { 
            //abrir archivo en modo lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //ejemplifica cada línea de nuestro texto
            String linea = entrada.readLine(); //ve a leer la primera línea
            int indice = 1; //no debe partir en 0
            //llamando para comparar
            boolean encontrada = false;
            String buscar = pelicula.getNombre();
            
            while (linea != null) {
                //con esto ignora si es mayuscula o minuscula
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    encontrada = true;
                    break;
                }
                
                linea = entrada.readLine();
                indice++;
            }
            
             if (encontrada) {
                 System.out.println("Pelicula " + linea 
                         + " encontrada - linea " + indice);
             } else {
                 System.out.println("No se encontro la pelicula: " + pelicula.getNombre());
             }
  
         } catch (Exception e) {
             System.out.println("Ocurrio un error: " + e.getMessage());
         } 
    }
}
