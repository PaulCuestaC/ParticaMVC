/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.dao;

import ec.edu.ups.java.practica02mvc.idao.ICompositorDAO;
import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public abstract class CompositorDAO implements ICompositorDAO {

    private List<Compositor> listaCompositor;

    public CompositorDAO() {
        listaCompositor = new ArrayList<>();
    }

    @Override
    public void create(Compositor compositor) {
        listaCompositor.add(compositor);
    }

    @Override
    public Compositor read(String cod) {
        for (Compositor compositor : listaCompositor) {
            if (compositor.getCodigo().equals(cod)) {
                return compositor;
            }
        }
        return null;
    }

    @Override
    public void update(Compositor compositor) {
        for (int i = 0; i < listaCompositor.size(); i++) {
            Compositor cantanteGuardada = listaCompositor.get(i);
            if (cantanteGuardada.getCodigo().equals(compositor.getCodigo())) {
                listaCompositor.set(i, compositor);
                break;
            }
        }
    }

    @Override
    public void delete(String cod) {
        for (int i = 0; i < listaCompositor.size(); i++) {
            Compositor personaGuardada = listaCompositor.get(i);
            if (personaGuardada.getCodigo().equals(cod)) {
                listaCompositor.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Compositor> list() {
        return listaCompositor;
    }

}
