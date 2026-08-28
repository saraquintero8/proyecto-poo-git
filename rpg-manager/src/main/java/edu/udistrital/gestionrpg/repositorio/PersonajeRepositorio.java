package edu.udistrital.gestionrpg.repositorio;

import edu.udistrital.gestionrpg.modelo.Personaje;
import java.util.ArrayList;
import java.util.List;

public class PersonajeRepositorio {

    private static List<Personaje> listaPersonajes = new ArrayList<>();

    public void guardar(Personaje p) {
        listaPersonajes.add(p);
    }

    public List<Personaje> obtenerTodos() {
        return listaPersonajes;
    }
}