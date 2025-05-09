import universities.*;
import universities.Class;

import java.util.Scanner;

public class Principal {
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
                    try {
                        System.out.println("Código de clase:");
                        long cod = Long.parseLong(sc.nextLine());

                        System.out.println("Nombre:");
                        String nombre = sc.nextLine();

                        System.out.println("Horario:");
                        long horario = sc.nextLong();

                        System.out.println("¿Está abierta? (true/false):");
                        boolean abierta = Boolean.parseBoolean(sc.nextLine());

                        System.out.println("Correo del profesor:");
                        long email = Long.parseLong(sc.nextLine());

                        Professor profe = null;
                        for (Professor p : uni.getProfessors()) {
                            if (p.getEmail() == email) {
                                profe = p;
                                break;
                            }
                        }

                        if (profe == null) {
                            System.out.println("Profesor no encontrado.");
                            break;
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
                    break;
                }

                case 2: {
                    System.out.println("Código de clase a buscar:");
                    long cod = Long.parseLong(sc.nextLine());
                    boolean encontrado = false;
                    for (Class c : uni.getClasses()) {
                        if (c.getCode() == cod) {
                            System.out.println("Clase encontrada: " + c.getName() + " - " + c.getHorario());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Clase no encontrada.");
                    }
                    break;
                }

                case 3: {
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
                    break;
                }

                case 4: {
                    System.out.println("Código de clase:");
                    long cod = Long.parseLong(sc.nextLine());
                    for (Class c : uni.getClasses()) {
                        if (c.getCode() == cod) {
                            System.out.println("Estudiantes inscritos en " + c.getName() + ":");
                            for (Student s : c.getStudents()) {
                                System.out.println("- " + s.getName());
                            }
                        }
                    }
                    break;
                }

                case 5:
                    boolean error5 = true;
                    while(error5) {
                        try {
                            System.out.print("Tipo de profesor que desea agregar (planta o cátedra): ");
                            String TipoProfesor = sc.nextLine();
                            System.out.print("email: ");
                            long emailProfessor = sc.nextLong();
                            System.out.print("name: ");
                            String nameProfessor = sc.nextLine();
                            if (TipoProfesor.equalsIgnoreCase("planta")) {
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
                                System.out.print("Tarifa por hora: ");
                                double rateProfesor= sc.nextDouble();
                                System.out.print("Horas por mes: ");
                                int horasProfesor= sc.nextInt();
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
            }

            case 6: {
                boolean error6 = true;
                try {
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
                        if (encontrado == false){
                            throw new ProfessorNoEncontradoException("Profesor no encontrado por ese nombre");
                        }
                    } else if (criterio.equalsIgnoreCase("category")) {
                        System.out.println("Categoria del profesor que desea eliminar: ");
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
                        if (encontrado == false){
                            throw new ProfessorNoEncontradoException("Profesor no encontrado por esa categoria");
                        }

                    }

                } catch (ProfessorNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                catch (CriterioInvalidoException e) {
                    System.out.println("Criterio ingresado es inválido, intentelo de nuevo.");
                }
                catch (CategoriaInvalidaException e) {
                    System.out.println("Criterio ingresado es inválido, intentelo de nuevo.");
                }
                break;
            }

            case 7: {
                double totalNomina = 0.0;
                for(Professor p : uni.getProfessors()){
                    totalNomina += p.calcularSalario();
                }
                System.out.println("Nómina total: $" + totalNomina);
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