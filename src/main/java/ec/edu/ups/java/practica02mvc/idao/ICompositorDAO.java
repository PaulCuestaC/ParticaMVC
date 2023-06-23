/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.idao;

import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface ICompositorDAO {
      public abstract void create(Compositor compositor); //C

    public abstract Compositor read(String cod); //R

    public abstract void update(Compositor compositor); //U

    public abstract void delete(String cod); //D

    public abstract List<Compositor> list();
}
