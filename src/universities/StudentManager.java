package universities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentManager {
    public static void cargarEstudiantesDesdeArchivo(University uni, String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                long code = Long.parseLong(datos[0].trim());
                long id = Long.parseLong(datos[1].trim());
                String name = datos[2].trim();
                String facultad = datos[3].trim();

                Student estudiante = new Student(code, id, name, facultad);
                uni.getStudents().add(estudiante);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de estudiantes.");
        }
        catch (NumberFormatException e) {
            System.out.println("Error en formato numérico en el archivo: " + e.getMessage());
        }
    }
}