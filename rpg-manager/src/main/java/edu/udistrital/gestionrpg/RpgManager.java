package edu.udistrital.gestionrpg;

import edu.udistrital.gestionrpg.controlador.PersonajeControlador;
import io.javalin.Javalin;

public class RpgManager {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);

        PersonajeControlador controlador = new PersonajeControlador();
        app.get("/personajes", controlador::obtenerTodos);
    }
}