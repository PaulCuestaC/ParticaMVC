/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.controlador;

import ec.edu.ups.java.practica02mvc.dao.CantanteDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Disco;

/**
 *
 * @author ESTUDIANTE
 */
public class ControladorCantante {
    private Cantante cantante;
    private CantanteDAO cantanteDAO;
    
    
    
    public void crear(Cantante cantante){
        this.cantante = cantante;
        cantanteDAO.create(cantante);
        
    }
    public Cantante  buscar(String cod){
        this.cantante=cantanteDAO.read(cod);;
        return this.cantante;
        
    }
    
    public void agregarDisco(Disco disco, String cod){
        this.cantante = cantanteDAO.read(cod);
        cantante.AgregarDisco(disco);
        
    }
}
