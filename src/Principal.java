import universities.*;
import universities.Class;

import java.util.Scanner;

public class Principal {

    public static void crearClase(University uni, Scanner sc)
    {
        try {
            System.out.println("Codigo de clase:");
            long cod = Long.parseLong(sc.nextLine());

            System.out.println("Nombre:");
            String nombre = sc.nextLine();

            System.out.println("Horario:");
            String horario = sc.nextLine();

            boolean abierta = false;

            System.out.println("¿Está abierta? (true/false):");
            String abierta1 = sc.nextLine();
            while (!abierta1.equalsIgnoreCase("true") && !abierta1.equalsIgnoreCase("false")) {
                System.out.println("¿Está abierta? (true/false):");
                abierta1 = sc.nextLine();
            }

            if (abierta1.equalsIgnoreCase("true")) {
                abierta = true;
            } else if (abierta1.equalsIgnoreCase("true")) {
                abierta = false;
            }
            System.out.println("Correo del profesor:");
            String email = sc.nextLine();

            Professor profe = null;
            for (Professor p : uni.getProfessors()) {
                if (email.equalsIgnoreCase(p.getEmail())) {
                    profe = p;
                    break;
                }
            }

            if (profe == null) {
                System.out.println("Profesor no encontrado.");
                return;
            }

            Class nueva = new Class(cod, nombre, abierta, horario, profe);

            for (Class c : uni.getClasses()) {
                if (nueva.conflictoHorario(c)) {
                    System.out.println("Conflicto de horario con otra clase del mismo profesor.");
                    throw new Exception("No se puede crear la clase.");
                }
            }

            uni.getClasses().add(nueva);
            System.out.println("Clase creada.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void buscarClaseCodigo(University uni, Scanner sc)
    {
        try
        {
            System.out.println("Codigo de clase a buscar:");
            long cod = Long.parseLong(sc.nextLine());
            boolean encontrado = false;
            for (Class c : uni.getClasses()) {
                if (c.getCode() == cod) {
                    System.out.println("Clase encontrada: " + c.getName() + " - " + c.getHorario());
                    encontrado = true;
                }
            }
            if (!encontrado)
            {
                System.out.println("Clase no encontrada.");
            }
        }catch (Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void inscribirEstudianteClase(University uni, Scanner sc)
    {
        try {
            System.out.println("Código del estudiante:");
            long codEst = Long.parseLong(sc.nextLine());

            System.out.println("Código de la clase:");
            long codClase = Long.parseLong(sc.nextLine());

            Student s = null;
            Class c = null;

            for (Student st : uni.getStudents()) {
                if (st.getCode() == codEst) {
                    s = st;
                    break;
                }
            }

            for (Class cl : uni.getClasses()) {
                if (cl.getCode() == codClase) {
                    c = cl;
                    break;
                }
            }

            if (s == null || c == null) {
                throw new Exception("Clase o estudiante no encontrado.");
            }

            s.inscribirClase(c);
            c.inscribirEstudiante(s);
            System.out.println("Estudiante inscrito.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarEstudiantesInscritos(University uni, Scanner sc)
    {
        try
        {
            System.out.println("Codigo de clase: ");
            long cod=Long.parseLong(sc.nextLine());
            boolean encontrado=false;
            for(Class c: uni.getClasses())
            {
                if(c.getCode()==cod)
                {
                    System.out.println("Estudiantes inscritos en "+c.getName()+ ":");
                    for(Student s: c.getStudents())
                    {
                        System.out.println("-"+ s.getName());
                    }
                    encontrado=true;
                }
            }
            if (!encontrado)
            {
                System.out.println("Clase no encontrada");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void agregarProfesor(University uni, Scanner sc) throws TipoDeProfessorInvalidoException, CategoriaInvalidaException, YaExisteProfessorException, LecturaInvalidaException {
        System.out.print("Tipo de profesor que desea agregar (planta o cátedra): ");
        String TipoProfesor = sc.nextLine();
        if (TipoProfesor.equalsIgnoreCase("planta")) {
            System.out.print("email: ");
            String emailProfessor = sc.nextLine();
            System.out.print("name: ");
            String nameProfessor = sc.nextLine();
            System.out.print("Categoría (ASSISTANT, ASSOCIATE o REGULAR): ");
            String categoria= sc.nextLine();
            ProfessorCategory categoryProfessor;
            if (categoria.equalsIgnoreCase("ASSISTANT")) {
                categoryProfessor = ProfessorCategory.ASSISTANT;
            } else if (categoria.equalsIgnoreCase("ASSOCIATE")) {
                categoryProfessor = ProfessorCategory.ASSOCIATE;
            }
            else if (categoria.equalsIgnoreCase("REGULAR")) {
                categoryProfessor = ProfessorCategory.REGULAR;
            }
            else{
                throw new CategoriaInvalidaException("Categoria inválida");
            }
            FullProfessor nuevoProfesorF = new FullProfessor(emailProfessor, nameProfessor, categoryProfessor);
            for(Professor p : uni.getProfessors()){
                if (p.getName().equalsIgnoreCase(nameProfessor)) {
                    throw new YaExisteProfessorException("Ya existe un profesor con el nombre." + nameProfessor);
                }
            }
            uni.getProfessors().add(nuevoProfesorF);
            System.out.println("Profesor agregado");

        }
        else if (TipoProfesor.equalsIgnoreCase("cátedra") | TipoProfesor.equalsIgnoreCase("catedra")){
            System.out.print("email: ");
            String emailProfessor = sc.nextLine();
            System.out.print("name: ");
            String nameProfessor = sc.nextLine();
            System.out.print("Tarifa por hora: ");
            double rateProfesor= sc.nextDouble();
            sc.nextLine();
            System.out.print("Horas por mes: ");
            int horasProfesor= sc.nextInt();
            sc.nextLine();
            Lecturer nuevoProfesorL = new Lecturer(emailProfessor, nameProfessor, horasProfesor, rateProfesor);
            for(Professor p : uni.getProfessors()){
                if (p.getName().equalsIgnoreCase(nameProfessor)) {
                    throw new YaExisteProfessorException("Ya existe un profesor con el nombre." + nameProfessor + " y el email." + emailProfessor);
                }
            }
            uni.getProfessors().add(nuevoProfesorL);
            System.out.println("Profesor agregado");

        }
        else{
            throw new TipoDeProfessorInvalidoException("Tipo de profesor inválido.");
        }
    }
    public static void eliminarProfesor(University uni, Scanner sc) throws ProfessorNoEncontradoException, CriterioInvalidoException, CategoriaInvalidaException, LecturaInvalidaException {
        System.out.println("Por qué criterio desea buscar al profesor que desea eliminar? (name o category): ");
        String criterio = sc.nextLine();
        if (criterio.equalsIgnoreCase("name")) {
            System.out.println("Nombre del profesor que desea eliminar: ");
            String nameProfesor = sc.nextLine();
            boolean encontrado = false;
            for (Professor p : uni.getProfessors()) {
                if (p.getName().equalsIgnoreCase(nameProfesor)) {
                    uni.getProfessors().remove(p);
                    System.out.println("Profesor eliminado por nombre.");
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                throw new ProfessorNoEncontradoException("Profesor no encontrado por ese nombre");
            }
        } else if (criterio.equalsIgnoreCase("category")) {
            System.out.println("Categoria del profesor que desea eliminar: ");
            String categoria = sc.nextLine();
            ProfessorCategory categoryProfessor;
            if (categoria.equalsIgnoreCase("ASSISTANT")) {
                categoryProfessor = ProfessorCategory.ASSISTANT;
            } else if (categoria.equalsIgnoreCase("ASSOCIATE")) {
                categoryProfessor = ProfessorCategory.ASSOCIATE;
            } else if (categoria.equalsIgnoreCase("REGULAR")) {
                categoryProfessor = ProfessorCategory.REGULAR;
            } else {
                throw new CategoriaInvalidaException("Categoria inválida");
            }
            boolean encontrado = false;
            for (Professor p : uni.getProfessors()) {
                if (p instanceof FullProfessor) {
                    FullProfessor pFullProfessor = (FullProfessor) p;
                    if (pFullProfessor.getCategory() == categoryProfessor) {
                        uni.getProfessors().remove(p);
                        System.out.println("Profesor eliminado por categoria");
                        encontrado = true;
                    }
                }
            }
            if (encontrado == false) {
                throw new ProfessorNoEncontradoException("Profesor no encontrado por esa categoria");
            }
        }
    }
    public static void calcularNomina(University uni) {
        double totalNomina = 0.0;
        for(Professor p : uni.getProfessors()){
            totalNomina += p.calcularSalario();
        }
        System.out.println("Nómina total: $" + totalNomina);
    }


    public static void main(String[] args) throws ProfessorNoEncontradoException {
        University uni = new University();
        Scanner sc = new Scanner(System.in);

        ProfessorManager.llenarProfesoresUniversidad(uni);
        StudentManager.cargarEstudiantesDesdeArchivo(uni, "src/estudiantes.txt");
        University.llenarClasesUniversidad(uni);

        int opcion;
        do {
            System.out.println("--- MENÚ UNIVERSIDAD ---");
            System.out.println("1. Crear clase");
            System.out.println("2. Buscar clase por código");
            System.out.println("3. Inscribir estudiante en clase");
            System.out.println("4. Mostrar estudiantes inscritos a una clase");
            System.out.println("5. Agregar profesor");
            System.out.println("6. Eliminar profesores por tipo");
            System.out.println("7. Calcular nómina de profesores");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    crearClase(uni, sc);
                    break;
                }

                case 2: {
                    buscarClaseCodigo(uni, sc);
                    break;
                }

                case 3: {
                    inscribirEstudianteClase(uni, sc);
                    break;
                }

                case 4: {
                    mostrarEstudiantesInscritos(uni, sc);
                    break;
                }

                case 5:
                    try {
                        agregarProfesor( uni, sc);
                    }
                    catch (TipoDeProfessorInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error en el formato de los datos");
                    }
                    catch (YaExisteProfessorException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (CategoriaInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch (LecturaInvalidaException e) {
                        System.out.println("Error en el formato de la fecha, intente de nuevo");
                    }
                    break;

                case 6: {
                    try {
                        eliminarProfesor(uni, sc);

                    } catch (ProfessorNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch (CriterioInvalidoException e) {
                        System.out.println("Criterio ingresado es inválido, intentelo de nuevo.");
                    }
                    catch (CategoriaInvalidaException e) {
                        System.out.println("Criterio ingresado es inválido, intentelo de nuevo.");
                    }
                    catch (LecturaInvalidaException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case 7: {
                    calcularNomina( uni);
                    break;
                }

                case 8:
                    System.out.println("Gracias");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}