package universities;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private long code;
    private String name;
    private boolean isOpen;
    private String horario;
    private Professor professor;
    private List<Student> students=new ArrayList<>();

    public Class(long code, String name, boolean isOpen, String horario, Professor professor) {
        this.code = code;
        this.name = name;
        this.isOpen = isOpen;
        this.horario = horario;
        this.professor = professor;
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

    public String getHorario() {
        return horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void inscribirEstudiante(Student student)
    {
        students.add(student);
    }
    public boolean conflictoHorario(Class otraClase)
    {
        if(this.professor.getEmail()==otraClase.getProfessor().getEmail()&& this.horario != otraClase.getHorario())
        {
            return true;
        }
        return false;
    }
}