package edu.udistrital.gestionrpg;

import edu.udistrital.gestionrpg.controlador.PersonajeControlador;
import io.javalin.Javalin;

public class RpgManager {

    public static void main(String[] args) {
        // 1. Creamos Javalin e indicamos la carpeta de archivos estáticos antes de iniciar
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
        }).start(8081);

        // 2. Instanciamos el controlador y definimos las rutas
        PersonajeControlador controlador = new PersonajeControlador();
        app.get("/personajes", controlador::obtenerTodos);
        app.post("/personajes", controlador::crear); // O el nombre que le hayas puesto al método en tu PersonajeControlador
    }
}