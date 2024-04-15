package logicaApp;

import java.util.ArrayList;

public class Alumnos {
    ArrayList<Alumno> alumnos;
    public Alumnos() {
        alumnos = new ArrayList<>();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
