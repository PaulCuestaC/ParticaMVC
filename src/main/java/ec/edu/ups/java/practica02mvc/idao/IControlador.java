/*
Case IControlador con los metodos de CRUD
*/
package ec.edu.ups.java.practica02mvc.idao;

public interface IControlador {
 
    public abstract void create(Object obj); //C
    public abstract Object read(Object obj); //R
    public abstract void update(Object obj); //U
    public abstract void delete(Object obj); //D
    public abstract void list();
    
}
