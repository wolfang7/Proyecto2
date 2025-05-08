package universities;
import java.util.ArrayList;
import java.util.List;

import static universities.ProfessorCategory.*;

public class ProfessorManager {

    public static void llenarProfesoresUniversidad(University university) {

        List<Professor> professors = new ArrayList<>();

        professors.add(new FullProfessor(201,"Manuel Sanabria", ASSISTANT));
        professors.add(new FullProfessor(243,"Oscar Ortíz", ASSOCIATE));
        professors.add(new FullProfessor(325,"Esteban Sandoval", REGULAR));
        try {
            professors.add(new Lecturer(546, "Juan Carlos Quevedo", 20, 48));
            professors.add(new Lecturer(564, "Sara Rodríguez", 21, 50));
            professors.add(new Lecturer(233, "Manuel Pérez", 12, 35));
            professors.add(new Lecturer(453, "Oscar Prieto", 11, 45));
            professors.add(new Lecturer(234, "Alejandro Bautista", 30, 38));
            professors.add(new Lecturer(231, "Juan Rosales", 15, 42));
            professors.add(new Lecturer(121, "Sara Agut", 50, 37));
        }
        catch (LecturaInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        university.getProfessors().addAll(professors);
    }
}