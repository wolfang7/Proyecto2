import java.util.List;
import java.util.Scanner;

public class ProfessorManager {

    public static void añadirLecturer(List<Professor> professors, Scanner sc) {
        try {
            System.out.println("Ingrese el nombre del Lecturer:");
            String name = sc.nextLine();

            for (Professor p : professors) {
                if (p.getName().equalsIgnoreCase(name)) {
                    throw new YaExisteProfessor("Ya existe un profesor con ese nombre.");
                }
            }

            System.out.println("Ingrese su ID:");
            String id = sc.nextLine();

            System.out.println("Ingrese horas por mes:");
            int hours = Integer.parseInt(sc.nextLine());

            System.out.println("Ingrese tarifa por hora:");
            double rate = Double.parseDouble(sc.nextLine());

            Lecturer newLecturer = new Lecturer(name, id, hours, rate);
            professors.add(newLecturer);

            System.out.println("Lecturer agregado exitosamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
        } catch (YaExisteProfessor | LecturaInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}