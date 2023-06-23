/*
 * Clase Cancion que abstrae los atributos
 */
package ec.edu.ups.java.practica02mvc.modelo;


public class Cancion { 
    private int codigo; //atributo entero que guarda el codigo de la clase Cancion
    private String titulo;//atributo String que guarda el titulo de la clase Cancion
    private String letra;//atributo String que guarda el letra de la clase Cancion
    private double tiempoEnMinutos; //atributo decimal que guarda el tiempo en minutos de la clase Cancion

    /*
     * Constructor vacío de la clase Cancion
     */
    public Cancion() {
    }
    /*
     * Constructor con parámetros de la clase Persona.
     * @param codigo: int, código de la cancion
     * @param titulo: String, titulo de la cancion
     * @param letra: String, letra de la cancion
     * @param tiempoEnMinutos: tiempo en minutos de la cancion
     */
    public Cancion(int codigo, String titulo, String letra, double tiempoEnMinutos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.letra = letra;
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    //Getters and Setters de la clase cancion
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public double getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) {
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    /*
    Metodo toString que devuelve de forma de string los atributos
    */
    @Override
    public String toString() {
        return "Cancion{" + "codigo=" + codigo + ", titulo=" + titulo + ", letra=" + letra + ", tiempoEnMinutos=" + tiempoEnMinutos + '}';
    }

    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Cancion.
     * @return el valor del hashcode de la instancia actual de la clase Cancion
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    /*
    Compara si la instancia actual de la clase Cancion es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Cancion
    @return true si la instancia actual de la clase Cancion es igual al objeto pasado como parametro,
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
}