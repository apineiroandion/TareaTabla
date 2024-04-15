package logicaApp;

import interfazUsuario.Ventana;

public class Main {
    public static void main(String[] args) {
        Alumnos alumnos = new Alumnos();
        Ventana ventana = new Ventana(alumnos);
        ventana.setVisible(true);
    }
}
