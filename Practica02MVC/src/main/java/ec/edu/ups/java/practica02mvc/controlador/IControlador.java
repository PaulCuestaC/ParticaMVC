/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.controlador;

public interface IControlador {
 
    public abstract void create(Object obj); //C
    public abstract Object read(Object obj); //R
    public abstract void update(Object obj); //U
    public abstract void delete(Object obj); //D
    public abstract void list();
    
}
