package universities;
import java.util.ArrayList;
import java.util.List;

import static universities.ProfessorCategory.*;

public class ProfessorManager {

    public static void llenarProfesoresUniversidad(University university) {

        List<Professor> professors = new ArrayList<>();

        professors.add(new FullProfessor("Manuel Sanabria@yahoo.com","Manuel Sanabria", ASSISTANT));
        professors.add(new FullProfessor("Oscar Ortíz@gmail.com","Oscar Ortíz", ASSOCIATE));
        professors.add(new FullProfessor("Esteban Sandoval@","Esteban Sandoval", REGULAR));
        try {
            professors.add(new Lecturer("Juan.Carlos Quevedo@gmail.com", "Juan Carlos Quevedo", 20, 48));
            professors.add(new Lecturer("Sara.Rodríguez@hotmail.com", "Sara Rodríguez", 21, 50));
            professors.add(new Lecturer("Manuel.Pérez@yahoo.com", "Manuel Pérez", 12, 35));
            professors.add(new Lecturer("Oscar.Prieto@gmail.com", "Oscar Prieto", 11, 45));
            professors.add(new Lecturer("Alejandro.Bautista@hotmail.com", "Alejandro Bautista", 30, 38));
            professors.add(new Lecturer("Juan.Rosales@gmail.com", "Juan Rosales", 15, 42));
            professors.add(new Lecturer("Sara.Agut@yahoo.com", "Sara Agut", 50, 37));
        }
        catch (LecturaInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        university.getProfessors().addAll(professors);
    }
}