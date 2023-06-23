/*
 * Clase abstracta Persona que sirve de base para la creación de cantantes y compositores.
 */
package ec.edu.ups.java.practica02mvc.modelo;


public abstract class Persona {

    private int codigo; // atributo entero que guarda el código de la persona
    private String nombre; // atributo String que guarda el nombre de la persona
    private String apellido; // atributo String que guarda el apellido de la persona
    private int edad; // atributo entero que guarda la edad de la persona
    private String nacionalidad; // atributo String que guarda la nacionalidad de la persona
    private double salario; // atributo double que guarda el salario de la persona

    /*
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /*
     * Constructor con parámetros de la clase Persona.
     * @param codigo: int, código de la persona
     * @param nombre: String, nombre de la persona
     * @param apellido: String, apellido de la persona
     * @param edad: int, edad de la persona
     * @param nacionalidad: String, nacionalidad de la persona
     * @param salario: double, salario de la persona
     */
    public Persona(int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.salario = salario;
    }

    /*
     * Método abstracto para calcular el salario de la persona.
     */
    public abstract double calcularSalario();

    /*
     * Getter and Setter de los parametros
     */
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /*
    Metodo toString comentado debido a que los metodos toString de cantante y compositor
    no sobreescribian el metodo toString de la clase padre Persona
     */
    //@Override
    //public String toString() {
    //return "Persona{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", salario=" + salario + '}';
    //}
    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Persona.
     * @return el valor del hashcode de la instancia actual de la clase Persona
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    /*
    Compara si la instancia actual de la clase Persona es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Persona
    @return true si la instancia actual de la clase Persona es igual al objeto pasado como parametro,
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
