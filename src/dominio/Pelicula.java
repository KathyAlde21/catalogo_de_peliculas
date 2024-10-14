package dominio;

import java.util.Objects;

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

    //--------------------------
    //se generan con insertar code y sirve en algunos casos como ahora para
    //buscar correctamente el nombre llamado en main
    //HashCode => numero unico del objeto a crear
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    //Equals
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
        final Pelicula other = (Pelicula) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    //-----------------------------
    
    //Metodo
    @Override
    public String toString() {
        return "Pelicula{" 
                + "nombre=" + nombre 
                + '}';
    }
 
}
