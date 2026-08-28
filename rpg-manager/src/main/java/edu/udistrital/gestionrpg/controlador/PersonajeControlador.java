package edu.udistrital.gestionrpg.controlador;

import edu.udistrital.gestionrpg.repositorio.PersonajeRepositorio;
import io.javalin.http.Context;

public class PersonajeControlador {

    private PersonajeRepositorio repositorio = new PersonajeRepositorio();

    public void obtenerTodos(Context ctx) {
        ctx.json(repositorio.obtenerTodos());
    }
}