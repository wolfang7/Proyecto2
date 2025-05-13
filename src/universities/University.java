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

        Class clase1 = new Class(1001, "Matematicas", true, "LUNES:11:00-13:00,MIERCOLES:08:00-10:00,VIERNES:15:00-17:00", university.getProfessors().get(0));
        Class clase2 = new Class(1002, "Inglés 1", true, "MARTES:07:30-09:30,JUEVES:11:00-13:00,SABADO:10:00-12:00", university.getProfessors().get(1));
        Class clase3 = new Class(1003, "Francés 1", false, "LUNES:16:00-18:00,MIERCOLES:10:00-12:00,VIERNES:13:00-15:00", university.getProfessors().get(2));
        Class clase4 = new Class(1004, "Inglés 2", false, "MARTES:10:00-12:00,JUEVES:08:00-10:00", university.getProfessors().get(3));
        Class clase5 = new Class(1005, "Inglés 3", true, "LUNES:13:00-15:00,MIERCOLES:09:00-11:00,VIERNES:14:00-16:00", university.getProfessors().get(4));
        Class clase6 = new Class(1006, "Francés 2", false, "MARTES:08:30-10:30,JUEVES:14:30-16:30,SABADO:09:00-11:00", university.getProfessors().get(5));
        Class clase7 = new Class(1007, "POO", true, "LUNES:14:00-16:00,MARTES:11:00-13:00,JUEVES:10:00-12:00", university.getProfessors().get(6));
        Class clase8 = new Class(1008, "Bases de Datos", false, "MIERCOLES:07:00-09:00,VIERNES:16:00-18:00", university.getProfessors().get(7));
        Class clase9 = new Class(1009, "Cálculo Integral", true, "LUNES:10:00-12:00,MIERCOLES:15:00-17:00,VIERNES:08:00-10:00", university.getProfessors().get(8));
        Class clase10 = new Class(1010, "Cálculo Diferencial", true, "MARTES:09:00-11:00,JUEVES:13:00-15:00", university.getProfessors().get(9));

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