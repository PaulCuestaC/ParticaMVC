/*
Clase principal para ejecutar la logica que mira el cliente
*/

package ec.edu.ups.java.practica02mvc.vista;
import ec.edu.ups.java.practica02mvc.controlador.ControladorPersona;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import java.util.Scanner;

//Clase principal 
public class Principal {

    //Metodo principal que ejecuta el codigo al iniciar el programa
    public static void main(String[] args) {

        //Instancia de la clase Scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);
        //Llamamos a la clase ControladorPersona para utilizar sus metodos y constructor
        ControladorPersona controlador = new ControladorPersona();

        //Atributo entero para controlar el menu
        int op = 8;
        //Bucle infinito para repetir el bucle mientras la opcion sea diferente de 7
        while (op != 7) {
            System.out.println("1. Ingreso de cantante"); //Muestra la opcion 1 del menu en consola
            System.out.println("2. Ingreso de compositor"); //Muestra la opcion 2 del menu en consola
            System.out.println("3. Agregar clientes"); //Muestra la opcion 3 del menu en consola
            System.out.println("4. Imprimir persona"); //Muestra la opcion 4 del menu en consola
            System.out.println("5. Búsqueda de cantante por nombre de disco"); //Muestra la opcion 5 del menu en consola
            System.out.println("6. Búsqueda de compositor por nombre de canción"); //Muestra la opcion 6 del menu en consola
            System.out.println("7. Salir"); //Muestra la opcion 7 del menu en consola
            op = sc.nextInt(); // Recibimos la entrade del teclado y guardamos en la variable op
            sc.nextLine(); // Reiniciamos la entrada de teclado despues de ingresar un entero
            switch (op) { //Switch para comparar la variable op y saber que opcion del menu se necesita
                case 1: // En caso de que op sea 1 
                    Cantante cantante = agregarCantante(); //Creamos un objeto de clase hija Cantante para guardar el resultado del metodo agregarCantante
                    controlador.create(cantante); //Enviamos el objeto de clase hija cantante a la clase controlador que guardar en la lista personas
                    break; // Salimos del case
                case 2: // En caso de que op sea 2
                    Compositor compositor = agregarCompositor();
                    controlador.create(compositor);
                    break;// Salimos del case
                case 3: // En caso de que op sea 3 
                    System.out.println("Ingrese el codigo del compositor a agregar clientes"); //Mostramos que necesitamos el codigo del compositor
                    int codigo = sc.nextInt(); // Atributo entero donde guardamos el codigo de compositor a guardar clientes
                    sc.nextLine(); // Reiniciamos la entrada de teclado despues de ingresar un entero
                    Compositor compositorRead = controlador.readCompositor(codigo); // Buscamos si existe el compositor con el codigo dado
                    if (compositorRead == null) { // Si el compositor devuelvto es nulo
                        System.out.println("Compositor no encontrado con codigo"); // Mostramos mensaje de error
                    } else { // Caso contrario 
                        compositorRead = agregarClientes(compositorRead); //Enviamos el compositor al metodo a agregar a clientes
                        controlador.updateCompositor(compositorRead); // Actualizamos el compositor una ves que agregamos clientes
                    }
                    break;// Salimos del case
                case 4: // En caso de que op sea 4
                    System.out.println(controlador.Imprimir());// Mostramos el mensaje que devuelve el metodo imprimir
                    break;// Salimos del case
                case 5: // En caso de que op sea 5
                    System.out.println("Ingrese el nombre del disco"); // Mostramos que necesitamos el nombre del disco para buscar cantantes
                    String nombreDisco = sc.nextLine(); // Guardamos la entrada del teclado en la variable nombreDisco
                    System.out.println(controlador.buscarCantantePorNombreDeDisco(nombreDisco)); // Mostramos en consola el string resultante del metodo buscar cantante por nombre del disco
                    break;// Salimos del case
                case 6: // En caso de que op sea 6
                    System.out.println("Ingrese el nombre de la cancion"); // Mostramos que necesitamos el nombre de la cancion para buscar compositor
                    String nombreCancion = sc.nextLine(); // Guardamos la entrada del teclado en la variable nombreCancion
                    System.out.println(controlador.buscarCompositorPorNombreDeCancion(nombreCancion)); // Mostramos en consola el string resultante del metodo buscar compositor por nombre de la cancion
                    break;// Salimos del case
                case 7: // En caso de que op sea 7
                    System.exit(0); // Cerramos la ejecucion
                    break;// Salimos del case
            }

        }
    }
    /*
    Metodo agregarCantante que muestra y pide todos los atributos de la clase hija cantante y la clase persona
    */
    public static Cantante agregarCantante() {
        //Instancia de la clase Scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);

        /*
        Mostrar y pedimos el atributo codigo de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el codigo del cantante: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo nombre de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el nombre del cantante: ");
        String nombre = sc.nextLine();

        /*
        Mostrar y pedimos el atributo apellido de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el apellido del cantante: ");
        String apellido = sc.nextLine();

        /*
        Mostrar y pedimos el atributo edad de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese la edad del cantante: ");
        int edad = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo nacionalidad de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese la nacionalidad del cantante: ");
        String nacionalidad = sc.nextLine();

        /*
        Mostrar y pedimos el atributo salario de la clase persona
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el salario del cantante: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo nombre artistico de la clase cantante
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el nombre artistico del cantante: ");
        String nombreArtistico = sc.nextLine();

        /*
        Mostrar y pedimos el atributo genero musical de la clase cantante
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el genero musical del cantante: ");
        String generoMusical = sc.nextLine();

        /*
        Mostrar y pedimos el atributo numero de sencillos de la clase cantante
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el numero de sencillos del cantante: ");
        int numeroDeSencillos = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo numero de conciertos de la clase cantante
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el numero de conciertos del cantante: ");
        int numeroDeConciertos = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo numero de giras de la clase cantante
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el numero de giras del cantante: ");
        int numeroDeGiras = sc.nextInt();
        sc.nextLine();

        /*
        Isntanciamos la clase cantante con el constructor y mandamos las variables guardas para inicializar la clase Cantante
        en la lista persona del controlador
        */
        Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad, salario);
        //Variable booleana para controlar si desea o no ingresar mas discos
        boolean continuar = true;
        //Bucle infinito hasta que el usuario decida ya no ingresar mas discos
        while (continuar) {
            //Mostramos en consola si el usuario decide entrar mas discos
            System.out.println("¿Desea ingresar un disco? (si/no)");
            //Leemos del teclado y guardamos en una variable para comparar si desea o no
            String respuesta = sc.nextLine();

            //Si la respuesta es si entonces
            if (respuesta.equalsIgnoreCase("si")) {
                /*
                Mostrar y pedimos el atributo codigo de la clase disco
                Leemos del teclado y guardamos en una variable 
                */
                System.out.println("Ingrese el codigo del disco: ");
                int codigoDisco = sc.nextInt();
                sc.nextLine();

                /*
                Mostrar y pedimos el atributo nombre de la clase disco
                Leemos del teclado y guardamos en una variable 
                */
                System.out.println("Ingrese el nombre del disco: ");
                String nombreDisco = sc.nextLine();

                /*
                Mostrar y pedimos el atributo ano de lanzamiento de la clase disco
                Leemos del teclado y guardamos en una variable 
                */
                System.out.println("Ingrese el año de lanzamiento del disco: ");
                int anioDeLanzamiento = sc.nextInt();
                sc.nextLine();
                
                //Utilizamos el metodo agregarDisco de la clase cantante para guardar los datos de entrada
                cantante.agregarDisco(codigoDisco, nombreDisco, anioDeLanzamiento);
            //Caso contrario 
            } else {
                //Continuar false para salir del bucle
                continuar = false;
            }
        }
        //Retornamos el obj cantante ya creada e inicializado con todas las variables
        return cantante;
    }

    /*
    Metodo agregarCompostiro que muestra y pide todos los atributos de la clase hija compositor y la clase persona
    */
    public static Compositor agregarCompositor() {
        //Instancia de la clase Scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);

        /*
        Mostrar y pedimos el atributo codigo de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el codigo del compositor: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo nombre de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el nombre del compositor: ");
        String nombre = sc.nextLine();

        /*
        Mostrar y pedimos el atributo apellido de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el apellido del compositor: ");
        String apellido = sc.nextLine();

        /*
        Mostrar y pedimos el atributo edad de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese la edad del compositor: ");
        int edad = sc.nextInt();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo nacionalidad de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese la nacionalidad del compositor: ");
        String nacionalidad = sc.nextLine();

        /*
        Mostrar y pedimos el atributo salario de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.println("Ingrese el salario del compositor: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        /*
        Mostrar y pedimos el atributo numero de composiciones de la clase compositor
        Leemos del teclado y guardamos en una variable 
        */
        System.out.print("Ingrese el número de composiciones: ");
        int numeroDeComposiciones = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        /*
        Isntanciamos la clase compositor con el constructor y mandamos las variables guardas para inicializar la clase Compositor
        en la lista personas del controlador
        */
        Compositor compositor = new Compositor(numeroDeComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
        //Variable booleana para controlar si desea o no ingresar mas canciones
        boolean continuar = true;
        //Bucle infinito hasta que el usuario decida ya no ingresar mas canciones
        while (continuar) {
            //Mostramos en consola si el usuario decide entrar mas canciones
            System.out.println("¿Desea ingresar una canción en el top 100 de Billboard? (si/no)");
            //Leemos del teclado y guardamos en una variable para comparar si desea o no
            String respuesta = sc.nextLine();

            //Si la respuesta es si entonces
            if (respuesta.equalsIgnoreCase("si")) {
                /*
                Mostrar y pedimos el atributo codigo de la clase cancion
                Leemos del teclado y guardamos en una variable 
                */
                System.out.print("Ingrese el Código: ");
                int codigoCancion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer de entrada

                /*
                Mostrar y pedimos el atributo titulo de la clase cancion
                Leemos del teclado y guardamos en una variable 
                */
                System.out.print("Ingrese el titulo: ");
                String tituloCancion = sc.nextLine();

                /*
                Mostrar y pedimos el atributo letra de la clase cancion
                Leemos del teclado y guardamos en una variable 
                */
                System.out.print("Ingrese letra: ");
                String letra = sc.nextLine();

                /*
                Mostrar y pedimos el atributo timpo en minutos de la clase cancion
                Leemos del teclado y guardamos en una variable 
                */
                System.out.print("Ingrese el tiempo en minuto: ");
                double tiempoEnMinutos = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer de entrada

                //Utilizamos el metodo agregarCancion de la clase compositor para guardar los datos de entrada
                compositor.agregarCancion(codigoCancion, tituloCancion, letra, tiempoEnMinutos);
            //Caso contrario
            } else {
                //Continuar false para salir del bucle
                continuar = false;
            }
        }
        //Retornamos el obj compositor ya creada e inicializado con todas las variables
        return compositor;
    }

    /*
    Metodo agregarClientes que muestra y pide todos los atributos de la clase cliente
    @param compositor: obj compositor al que agregamos los clientes
    */
    public static Compositor agregarClientes(Compositor compositor) {
        //Instancia de la clase Scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);
        //Variable booleana para controlar si desea o no ingresar mas clientes 
        boolean continuar = true;
        //Bucle infinito hasta que el usuario decida ya no ingresar mas clientes
        while (continuar) {
             //Mostramos en consola si el usuario decide entrar mas clientes
            System.out.println("¿Desea ingresar un cantante cliente? (si/no)");
            //Leemos del teclado y guardamos en una variable para comparar si desea o no
            String respuesta = sc.nextLine();

            //Si la respuesta es si entonces
            if (respuesta.equalsIgnoreCase("si")) {
                //Utilizamos el metodo agregarCantante para devolver un obj de clase Cantante
                Cantante cantante = agregarCantante();
                //Agregamos el obj cantante a la clase hija compositor
                compositor.agregarCliente(cantante);
            //Caso contrario
            } else {
                //Continuar false para salir del bucle
                continuar = false;
            }
        }
         //Retornamos el obj compositor ya creada e inicializado con todas las variables para ser actualizado
        return compositor;
    }
}
