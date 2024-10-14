package dominio;

public class Pelicula {
    
    private String nombre;
    
    //Constructores
    public Pelicula (){};

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //---------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo
    @Override
    public String toString() {
        return "Pelicula{" 
                + "nombre=" + nombre 
                + '}';
    }
 
}
