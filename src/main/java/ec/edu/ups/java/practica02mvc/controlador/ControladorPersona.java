/*
Clase controlador persona que contiene la lista de la clase personas, donde hacemos el CRUD
*/
package ec.edu.ups.java.practica02mvc.controlador;

import ec.edu.ups.java.practica02mvc.idao.IControlador;
import ec.edu.ups.java.practica02mvc.modelo.Cancion;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import ec.edu.ups.java.practica02mvc.modelo.Disco;
import ec.edu.ups.java.practica02mvc.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

//Clase ControladorPersona que implementa la Clase ICOntrolador para manejar sus metodos y sobreescribri
public class ControladorPersona implements IControlador {

    private List<Persona> personas; //Atributo lista de la clase personas

    
     /*
     * Constructor que inicializa la lista de la clase ControladorPersona
     */
    public ControladorPersona() { 
        personas = new ArrayList<>();
    }

    /*
    Metodo sobreescrito de clase IControlador que crea y anade el objeto de la clase Persona a la lista de Personas
    @param obj: Objeto que se pasa para agregar a la lista 
    */
    @Override
    public void create(Object obj) {
        if (obj instanceof Persona) {
            personas.add((Persona) obj);
        }
    }

    /*
    Metodo sobrescrito de la clase IControlador para obtener el obj Persona de la lista en caso de encontrarse
    @param obj: Objeto persona a buscar 
    */
    @Override
    public Object read(Object obj) {
        if (obj instanceof Integer) {
            int codigo = (int) obj;
            for (Persona persona : personas) {
                if (persona.getCodigo() == codigo) {
                    return persona;
                }
            }
        }

        return null;
    }

    /*
    Metodo sobreescrito de la clase IControlador para actualizar el obj Persona
    @param obj: Objeto a buscar y actualizar 
    */
    @Override
    public void update(Object obj) {

        if (obj instanceof Persona) {

            int codigo = ((Persona) obj).getCodigo();
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if (persona.getCodigo() == codigo) {
                    personas.set(i, (Persona) obj);
                    break;
                }
            }

        }

    }

    /*
    Metodo sobreescrito de la clase IControlador para eliminar el obj Persona
    @param obj: Objeto persona a eliminar 
    */
    @Override
    public void delete(Object obj) {
        if (obj instanceof Persona) {

            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if (persona.equals((Persona) obj)) {
                    personas.remove(i);
                    break;
                }
            }

        }
    }

    /*
    Metodo sobrescrito de la clase IControlador que muestra la lista de personas
    */
    @Override
    public void list() {
        for (Persona persona : personas) {
            //personas.stream().forEach(p -> System.out.println(p));
            System.out.println(persona.toString());
        }
    }

    /*
    Metodo imprimir que recorre la lista de objetos Persona y realiza una determinada accion
    dependiendo si el obj es Compositor o Cantante
    @return salida: String que contiene los valores de cada obj asi sea compositor o persona
    */
    public String Imprimir() {
        String salida = "";
        for (Persona persona : this.personas) {
            //If con la instruccion instanceOf para comprobar si es de la clase hija Compositor
            if (persona instanceof Compositor) {
                // Es un objeto de la clase Compositor
                Compositor compositor = (Compositor) persona;
                // Concatenamos la salida con el toString
                salida += compositor.toString() + " \nSalario Final: " + compositor.calcularSalario() + "\n";
                //else if con la instruccion instanceOf para comprobar si es de la clase hija Cantante
            } else if (persona instanceof Cantante) {
                // Es un objeto de la clase Cantante
                Cantante cantante = (Cantante) persona;
                // Concatenamos la salida con el toString
                salida += cantante.toString() + " \nSalario Final: " + cantante.calcularSalario() + "\n";;
            }
        }
        //Retornamos la variable salida para mostrar en la consola
        return salida;
    }

    /*
    Metodo para buscar un compositor 
    @param obj: Obj persona a buscar en caso de encontrarse verifica si es de clase compositor
    */
    public Compositor readCompositor(Object obj) {
        // If para comprobar si el obj que pasa es un int que es el tipo de variable Codigo 
        if (obj instanceof Integer) {
            int codigo = (int) obj;
            // Recorremos la lista de personas
            for (Persona persona : personas) {
                // Si el codigo entrante es igual al codigo de la lista persona Y la persona es de clase Compositor entonces
                if (persona.getCodigo() == codigo && persona instanceof Compositor) {
                    //Devolvemos el objeto que se busca
                    return (Compositor) persona;
                }
            }
        }

        return null;
    }

    /*
    Metodo para actualizar el obj Persona de clase Compositor
    @param obj: obj Persona de clase compositor a actualizar
    */
    public void updateCompositor(Object obj) {
        // Si el obj que entra es de clase compositor entonces
        if (obj instanceof Compositor) {
            // Obtenemos el codigo del objeto persona tipo compositor
            int codigo = ((Compositor) obj).getCodigo();
            //Recorremos el listado de personas
            for (int i = 0; i < personas.size(); i++) {
                //Obtenemos el objeto persona de la lista personas
                Persona persona = personas.get(i);
                //Si el codigo del obj persona es igual al codigo de la persona de lista Y este obj es de clase Compositor entonces
                if (persona.getCodigo() == codigo && persona instanceof Compositor) {
                    //Actualizamos el obj con el nuevo entrante
                    personas.set(i, (Compositor) obj);
                    break;
                }
            }

        }

    }

    /*
    Metodo que busca el cantante que tiene un disco con el nombre dado
    @param nombreDisco: nombre del disco para buscar la persona de clase cantante
    */
    public String buscarCantantePorNombreDeDisco(String nombreDisco) {
        String salida = "";
        //Recorremos la lista persona
        for (Persona persona : personas) {
            //Si la persona es de clase Cantante entonces
            if (persona instanceof Cantante) {
                //Obtenemos el obj persona y casteamos a clase Cantante
                Cantante cantante = (Cantante) persona;
                //De este cantante recorremos sus discos para encontrar el nombre del disco que buscamos
                for (Disco disco : cantante.getDiscografia()) {
                    //Si el nombre del disco que recorremos es igual al nombre del parametro de entrada entocnes
                    if (disco.getNombre().equalsIgnoreCase(nombreDisco)) {
                        //Concatenamos al string resultante el nombre y apellido del cantante 
                       salida += cantante.getNombre() + " " + cantante.getApellido() +"\n";
                        break;
                    }
                }
            }
        }
        //Retornamos el String de las personas que tienen un disco con el nombre como parametro
        return salida;
    }

    /*
    Metodo que busca el compostiro que tiene una cancion con el nombre dado
    @param nombreCancion: nombre de la cancion para buscar la persona de clase Compositor
    */
    public String buscarCompositorPorNombreDeCancion(String nombreCancion) {
        String salida="";
        //Recorremos la lista persona
        for (Persona persona : personas) {
            //Si la persona es de clase Compositor entonces
            if (persona instanceof Compositor) {
               //Obtenemos el obj persona y casteamos a clase Compositor
                Compositor compositor = (Compositor) persona;
                 //De este compositor recorremos sus canciones para encontrar el nombre de la cancion que buscamos
                for (Cancion cancion : compositor.getCancionesTop100Billboard()) {
                    //Si el nombre de la cancion que recorremos es igual al nombre del parametro de entrada entocnes
                    if (cancion.getTitulo().equalsIgnoreCase(nombreCancion)) {
                        //Concatenamos al string resultante el nombre y apellido del compositor
                        salida += compositor.getNombre() + " " + compositor.getApellido()+"\n";
                        break;
                    }
                }
            }
        }
        //Retornamos el String de las personas que tienen una cancion con el nombre como parametro
        return salida;
    }

}
