/*
 * Clase Cantante que abstrae los atributos
 */
package ec.edu.ups.java.practica02mvc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tians
 */
public class Cantante extends Persona {

    private String nombreArtistico; //atributo String que guarda el nombre artistico de la clase cancion
    private String generoMusical;//atributo String que guarda el genero musical de la clase cancion
    private int numeroDeSencillos; //atributo numerico que guarda el numero de sencillos de la clase cancion
    private int numeroDeConciertos; //atributo numerico que guarda el numero de conciertos de la clase cancion
    private int numeroDeGiras; //atributo numerico que guarda el numero de giras de la clase cancion
    private List<Disco> discografia; // atributo lista de discos que guarda la discografica de la calse Cancion

    /*
     * Constructor vacío de la clase Cancion
     */
    public Cantante() {
    }

    /*
    Constructor con parámetros de la clase Cantante.
    @param nombreArtistico: String, nombre artístico del cantante
    @param generoMusical: String, género musical del cantante
    @param numeroDeSencillos: int, número de sencillos del cantante
    @param numeroDeConciertos: int, número de conciertos del cantante
    @param numeroDeGiras: int, número de giras del cantante
    @param codigo: int, código de la persona
    @param nombre: String, nombre de la persona
    @param apellido: String, apellido de la persona
    @param edad: int, edad de la persona
    @param nacionalidad: String, nacionalidad de la persona
    @param salario: double, salario de la persona
     */
    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList<>();
    }

    //Gettes and Setters de la clase Cancion
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }

    /*
    Metodo toString que devuelve de forma de string los atributos
     */
    @Override
    public String toString() {
        return "Persona{" + "codigo=" + super.getCodigo() + ", nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", edad=" + super.getEdad() + ", nacionalidad=" + super.getNacionalidad() + ", salario=" + super.getSalario() + '}' + "Cantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }

    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Cantante
     * @return el valor del hashcode de la instancia actual de la clase Cantante
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombreArtistico);
        return hash;
    }

    /*
    Compara si la instancia actual de la clase Cantante es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Cantante
    @return true si la instancia actual de la clase Cantante es igual al objeto pasado como parametro,
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
        final Cantante other = (Cantante) obj;
        return Objects.equals(this.nombreArtistico, other.nombreArtistico);
    }

    /*

Calcula el salario del cantante teniendo en cuenta diferentes factores.

@return double, salario calculado del cantante
     */
    @Override
    public double calcularSalario() {
        double salario = super.getSalario(); // Obtiene el salario base de la clase padre

// Incrementa el salario en 1000 si el cantante tiene más de 10 sencillos y más de 3 giras
        if (this.numeroDeSencillos > 10 && this.numeroDeGiras > 3) {
            salario += 1000.0;
        }

// Incrementa el salario en un 5% si el cantante tiene entre 1 y 10 sencillos
        if (this.numeroDeSencillos >= 1 && this.numeroDeSencillos <= 10) {
            salario *= 1.05;
        }

// Incrementa el salario en un 3% si el cantante tiene entre 1 y 3 giras
        if (this.numeroDeGiras >= 1 && this.numeroDeGiras <= 3) {
            salario *= 1.03;
        }

// Incrementa el salario en 2000 si el cantante tiene al menos 5 discografías
        if (this.discografia.size() >= 5) {
            salario += 2000.0;
        }

        return salario; // Devuelve el salario final calculado
    }

    /*
    Metodo agregarDisco con los atributos de la clase Disco
    */
    public void agregarDisco(int codigo, String nombre, int anioDeLanzamiento) {
        Disco disco = new Disco(codigo, nombre, anioDeLanzamiento);
        //Agrega el disco a la lista discografia
        this.discografia.add(disco);
    }

}
