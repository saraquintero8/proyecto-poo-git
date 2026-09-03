package edu.udistrital.gestionrpg.controlador;

import edu.udistrital.gestionrpg.modelo.Personaje;
import edu.udistrital.gestionrpg.repositorio.PersonajeRepositorio;
import io.javalin.http.Context;

public class PersonajeControlador {

    private PersonajeRepositorio repositorio = new PersonajeRepositorio();

    public void obtenerTodos(Context ctx) {
        ctx.json(repositorio.obtenerTodos());
    }

    public void crear(Context ctx) {
        String nombre = ctx.formParam("nombre");
        String clase = ctx.formParam("clase");
        int nivel = Integer.parseInt(ctx.formParam("nivel"));
        int vidaInicial = 100;

        Personaje nuevo = new Personaje(nombre, clase, nivel, vidaInicial);
        repositorio.guardar(nuevo);

        ctx.redirect("/index.html");
    }
}