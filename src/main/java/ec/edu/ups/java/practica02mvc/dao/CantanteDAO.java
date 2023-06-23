/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.dao;

import ec.edu.ups.java.practica02mvc.idao.ICantanteDAO;
import ec.edu.ups.java.practica02mvc.modelo.Cancion;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Disco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public abstract class CantanteDAO implements ICantanteDAO {

    private List<Cantante> listaCantantes;

    public CantanteDAO() {
        listaCantantes = new ArrayList<>();
    }

    @Override
    public void create(Cantante cantante) {
        listaCantantes.add(cantante);
    }

    @Override
    public Cantante read(String cod) {

        for (Cantante cantante : listaCantantes) {
            if (cantante.getCodigo().equals(cod)) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante cantanteGuardada = listaCantantes.get(i);
            if (cantanteGuardada.getCodigo().equals(cantante.getCodigo())) {
                listaCantantes.set(i, cantante);
                break;
            }
        }
    }

    @Override
    public void delete(String cod) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante personaGuardada = listaCantantes.get(i);
            if (personaGuardada.getCodigo().equals(cod)) {
                listaCantantes.remove(i);
                break;
            }
        }
    }

    public void agregarCancion(Disco disco) {

        Cantante cantante= new Cantante();
     
        cantante.AgregarDisco(disco);
    }

    @Override
    public List<Cantante> list() {
        return listaCantantes;
    }

}
