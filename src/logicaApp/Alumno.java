package logicaApp;

public class Alumno {
    private String name;
    private String surnume;
    private String curso;

    public Alumno(String name, String surnume, String curso) {
        this.name = name;
        this.surnume = surnume;
        this.curso = curso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnume() {
        return surnume;
    }

    public void setSurnume(String surnume) {
        this.surnume = surnume;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
