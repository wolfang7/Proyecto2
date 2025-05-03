package universities;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private long code;
    private String name;
    private boolean isOpen;
    private long horario;
    private Professor professor;
    private List<Student> students;

    public Class(long code, String name, long horario, Professor professor) {
        this.code = code;
        this.name = name;
        this.horario = horario;
        this.professor = professor;
    }

    public Class(long code, String name, long horario, List<Student> students, Professor professor) {
        this.code = code;
        this.name = name;
        this.horario = horario;
        this.students = students;
        this.professor = professor;
    }

    public Class(long code, String name, boolean isOpen, long horario, Professor professor, List<Student> students) {
        this.code = code;
        this.name = name;
        this.isOpen = isOpen;
        this.horario = horario;
        this.professor = professor;
        this.students = students;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setHorario(long horario) {
        this.horario = horario;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public long getHorario() {
        return horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }
}
