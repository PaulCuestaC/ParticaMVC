/*
 * Clase Disco que abstrae los atributos
 */
package ec.edu.ups.java.practica02mvc.modelo;

public class Disco {

    private int codigo; // atributo numerico que guarda el codigo del disco
    private String nombre; // atributo String que guarda el nombre del disco
    private int anioDeLanzamiento; // atributo numerico que guarda el ano de lanzamiento

    /*
     * Constructor vacío de la clase Cancion
     */
    public Disco() {
    }

    /*
 * Constructor con parámetros de la clase Disco.
 * @param codigo: int, código del disco
 * @param nombre: String, nombre del disco
 * @param anioDeLanzamiento: int, año de lanzamiento del disco
     */
    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    //Getters and Setters de la clase Disco
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    /*
    Metodo toString que devuelve de forma de string los atributos
    */
    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombre + ", anioDeLanzamiento=" + anioDeLanzamiento + '}';
    }

    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Disco
     * @return el valor del hashcode de la instancia actual de la clase Disco
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.codigo;
        return hash;
    }

     /*
    Compara si la instancia actual de la clase Disco es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Disco
    @return true si la instancia actual de la clase Disco es igual al objeto pasado como parametro,
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disco other = (Disco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
