package universities;

import java.util.ArrayList;
import java.util.List;

import static universities.ProfessorCategory.*;

public class University {
    private List<Student> students=new ArrayList<>();
    private List<Professor> professors=new ArrayList<>();
    private List<Class> classes=new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public static void llenarClasesUniversidad(University university) {

        List<Class> classes = new ArrayList<>();
        Class clase1 = new Class(1001, "Matematicas", true, 10, university.getProfessors().get(0));
        Class clase2 = new Class(1002, "Inglés 1", true, 12, university.getProfessors().get(1));
        Class clase3 = new Class(1003, "Francés 1", false, 43, university.getProfessors().get(2));
        Class clase4 = new Class(1004, "Inglés 2", false, 46, university.getProfessors().get(3));
        Class clase5 = new Class(1005, "Inglés 3", true, 34, university.getProfessors().get(4));
        Class clase6 = new Class(1006, "Francés 2", false, 78, university.getProfessors().get(5));
        Class clase7 = new Class(1007, "POO", true, 45, university.getProfessors().get(6));
        Class clase8 = new Class(1008, "Bases de Datos", false, 23, university.getProfessors().get(7));
        Class clase9 = new Class(1009, "Cálculo Integral", true, 10, university.getProfessors().get(8));
        Class clase10 = new Class(1010, "Cálculo Diferencial", true, 11, university.getProfessors().get(9));

        classes.add(clase1);
        classes.add(clase2);
        classes.add(clase3);
        classes.add(clase4);
        classes.add(clase5);
        classes.add(clase6);
        classes.add(clase7);
        classes.add(clase8);
        classes.add(clase9);
        classes.add(clase10);
        university.getClasses().addAll(classes);
    }
}