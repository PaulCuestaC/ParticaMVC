/*
 * Clase Compositor que abstrae los atributos
 */
package ec.edu.ups.java.practica02mvc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compositor extends Persona{
    private int numeroDeComposiciones;//atributo entero que guarda el numero de Composiciones de la clase compositor
    private List<Cancion> cancionesTop100Billboard;//atributo lista que guarda las canciones de la clase compositor
    private List<Cantante> clientes; //atributo lista que guarda los clientes cantantes de la clase compositor

    /*
 * Constructor con parámetros de la clase Compositor.
 * 
 * @param numeroDeComposiciones: int, número de composiciones del compositor
 * @param codigo: int, código del compositor
 * @param nombre: String, nombre del compositor
 * @param apellido: String, apellido del compositor
 * @param edad: int, edad del compositor
 * @param nacionalidad: String, nacionalidad del compositor
 * @param salario: double, salario del compositor
 */
    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.cancionesTop100Billboard = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    /*
     * Constructor vacío de la clase Cancion
     */
    public Compositor() {
    }

    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getCancionesTop100Billboard() {
        return cancionesTop100Billboard;
    }

    public void setCancionesTop100Billboard(List<Cancion> cancionesTop100Billboard) {
        this.cancionesTop100Billboard = cancionesTop100Billboard;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }

    /*
    Metodo toString que devuelve de forma de string los atributos
    */
    @Override
    public String toString() {
        return "Persona{" + "codigo=" + super.getCodigo() + ", nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", edad=" + super.getEdad() + ", nacionalidad=" + super.getNacionalidad() + ", salario=" + super.getSalario() + '}' + "Compositor{" + "numeroDeComposiciones=" + numeroDeComposiciones + ", cancionesTop100Billboard=" + cancionesTop100Billboard + ", clientes=" + clientes + '}';
    }

    /*
     * Retorna el valor del hashcode de la instancia actual de la clase Compositor
     * @return el valor del hashcode de la instancia actual de la clase Compositor
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.numeroDeComposiciones;
        hash = 71 * hash + Objects.hashCode(this.cancionesTop100Billboard);
        hash = 71 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

     /*
    Compara si la instancia actual de la clase Compositor es igual a otro objeto.
    @param obj objeto a comparar con la instancia actual de la clase Compositor
    @return true si la instancia actual de la clase Compositor es igual al objeto pasado como parametro,
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
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.cancionesTop100Billboard, other.cancionesTop100Billboard)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }

    
    /* Calcula el salario del cantante teniendo en cuenta diferentes factores. 
    @return double, salario calculado del cantante 
    */
    @Override
    public double calcularSalario() {
        double salario = super.getSalario();
        // Incrementa el salario en 300 si el cantante tiene más de 5 numero de composiciones
        if (this.numeroDeComposiciones>5){
            salario += 300.0;
        }
        // Incrementa el salario en 0.10% si el cantante tiene más de 1 y menos de 3 canciones
        if (this.cancionesTop100Billboard.size()>=1 && this.cancionesTop100Billboard.size()<=3){
            salario *= 1.10;
        // Incrementa el salario en 0.20% si el cantante tiene más de 4 y menos de 6 canciones    
        }else if(this.cancionesTop100Billboard.size()>=4 && this.cancionesTop100Billboard.size()<=6){
            salario *= 1.20;
        // Incrementa el salario en 0.20% si el cantante tiene más de 6
        }else if(this.cancionesTop100Billboard.size()>6){
            salario *= 1.20;
        }
        //Retorna el salario
        return salario;
    }
    
    /*
    Metodo agregarCancion con los atributos de la clase Disco
    */
    public void agregarCancion(int codigo, String titulo, String letra, double tiempoEnMinutos){
        Cancion cancion=new Cancion(codigo,titulo,letra,tiempoEnMinutos);
        //Agrega el cancion a la lista canciones
        this.cancionesTop100Billboard.add(cancion);
    }
    
    /*
    Metodo agregarCliente con los atributos de la clase Disco
    */
    public void agregarCliente(Cantante cliente){
        //Agrega un cliente a la lista clientes
        this.clientes.add(cliente);
    }
}
