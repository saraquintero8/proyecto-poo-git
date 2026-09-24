package edu.udistrital.gestionrpg.controlador;

import edu.udistrital.gestionrpg.modelo.Personaje;
import edu.udistrital.gestionrpg.repositorio.PersonajeRepositorio;
import edu.udistrital.gestionrpg.servicio.PersonajeServicio;
import io.javalin.http.Context;

public class PersonajeControlador {

    private PersonajeRepositorio repositorio = new PersonajeRepositorio();
    private PersonajeServicio servicio = new PersonajeServicio();

    public void obtenerTodos(Context ctx) {
        ctx.json(repositorio.obtenerTodos());
    }

    public void crear(Context ctx) {
        String nombre = ctx.formParam("nombre");
        String clase = ctx.formParam("clase");
        int nivel = Integer.parseInt(ctx.formParam("nivel"));

        // Llamamos al servicio para validar antes de guardar
        if (!servicio.validarPersonaje(nombre, nivel, clase)) {
            ctx.status(400).result("Datos de personaje inválidos. Verifica el nombre, nivel (1-100) y clase (Guerrero, Mago, Arquero).");
            return;
        }

        int vidaInicial = 100;
        Personaje nuevo = new Personaje(nombre, clase, nivel, vidaInicial);
        repositorio.guardar(nuevo);

        ctx.redirect("/index.html");
    }
}