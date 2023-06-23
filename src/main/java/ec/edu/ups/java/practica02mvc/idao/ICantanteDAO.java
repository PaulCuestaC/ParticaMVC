/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.idao;

import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface ICantanteDAO {

    public abstract void create(Cantante cantante); //C

    public abstract Cantante read(String cod); //R

    public abstract void update(Cantante cantante); //U

    public abstract void delete(String cod); //D

    public abstract List<Cantante> list();
}
