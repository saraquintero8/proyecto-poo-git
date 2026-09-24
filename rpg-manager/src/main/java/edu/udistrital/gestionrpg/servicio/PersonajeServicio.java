package edu.udistrital.gestionrpg.servicio;

public class PersonajeServicio {

    public boolean validarPersonaje(String nombre, int nivel, String clase) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }

        if (nivel < 1 || nivel > 100) {
            return false;
        }

        if (!clase.equalsIgnoreCase("Guerrero") && 
            !clase.equalsIgnoreCase("Mago") && 
            !clase.equalsIgnoreCase("Arquero")) {
            return false;
        }

        return true;
    }
}