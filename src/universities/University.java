package universities;

import java.util.ArrayList;
import java.util.List;

public class University {

    private StudentsManager studentsManager;
    private List<Students> students;
    private List<Class> classes;
    private List<Professor> professors;
    private ProfessorManager professorManager;

    public University() {
    }

    public University(ProfessorManager professorManager, StudentsManager studentsManager) {
        this.professorManager = professorManager;
        this.studentsManager = studentsManager;
    }

    public University(StudentsManager studentsManager, List<Students> students, List<Class> classes, List<Professor> professors, ProfessorManager professorManager) {
        this.studentsManager = studentsManager;
        this.students = students;
        this.classes = classes;
        this.professors = professors;
        this.professorManager = professorManager;
    }



    public static void main(String[] args) {

        while (true) {

            System.out.println("\n Menú:");
            System.out.println("1. Rescatar un perro");
            System.out.println("2. Adoptar un perro");
            System.out.println("3. Cambiar nombre de mascota");
            System.out.println("4. Mostrar adopciones");
            System.out.println("5. Guardar y Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del perro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la raza: ");
                    String raza = scanner.nextLine();
                    System.out.print("Ingrese el color: ");
                    String color = scanner.nextLine();
                    boolean error = true;
                    while(error) {
                        try {
                            System.out.print("Ingrese la fecha de nacimiento (AAAA-MM-DD): ");
                            String[] fechaParts = scanner.nextLine().split("-");
                            Date fechaNacimiento = new Date(Integer.parseInt(fechaParts[0]), Integer.parseInt(fechaParts[1]) - 1, Integer.parseInt(fechaParts[2]));
                            Perro nuevoPerro = new Perro(nombre, raza, color, fechaNacimiento);
                            System.out.println(nuevoPerro.calcularEdad());
                            centro.rescatarMascota(nuevoPerro);
                            System.out.println("check.");
                            error = false;

                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error en el formato de la fecha, intente de nuevo");
                            guardarExcepcion(e);
                            error = true;
                        }
                        catch (AgeLessThanZeroOrMoreThanThirtyException e) {
                            System.out.println("Este perro es demasiado viejo para estar vivo, intente de nuevo");
                            guardarExcepcion(e);
                            error = true;
                        }
                    }
                    break;
                case 2:
                    boolean error1 = true;

                    while(error1) {
                        try {
                            System.out.print("Ingrese su cédula: ");
                            String cedula = scanner.nextLine();
                            Persona cliente = centro.buscarCliente(cedula);
                            if (cliente == null) {
                                System.out.print("Nombre del cliente: ");
                                String nombreCliente = scanner.nextLine();
                                cliente = new Persona(nombreCliente, cedula);
                                centro.agregarCliente(cliente);
                            }
                            System.out.println("Perros disponibles para adopción:");
                            centro.mostrarInternos();
                            System.out.print("Nombre del perro que desea adoptar: ");
                            String nombreAdoptar = scanner.nextLine();
                            Perro perroAdoptar = centro.buscarPerro(nombreAdoptar);
                            if (perroAdoptar != null) {
                                centro.darEnAdopcion(perroAdoptar, cliente);
                                System.out.println("Perro adoptado.");
                            } else {
                                System.out.println("Perro no encontrado.");
                            }
                            error1 = false;
                        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                            System.out.println("Error, intente de nuevo");
                            guardarExcepcion(e);
                            error1 = true;
                        }
                        catch(CedulaInvalidaException e){
                            System.out.println("Longitud de cedula invalida, intente de nuevo");
                            guardarExcepcion(e);
                            error1 = true;
                        }
                    }

                    break;
                case 3:
                    boolean error2 = true;

                    while(error2) {
                        try {
                            System.out.print("Ingrese su cédula: ");
                            String cedulaCambio = scanner.nextLine();
                            Persona personaCambio = centro.buscarCliente(cedulaCambio);
                            if (personaCambio != null) {
                                System.out.println("Mascotas actuales:");
                                for (Perro perrito : personaCambio.getMascotas()) {
                                    System.out.println(perrito);
                                }
                                System.out.print("Nombre actual del perro: ");
                                String nombreActual = scanner.nextLine();
                                Perro mascotaCambio = personaCambio.buscarMascota(nombreActual);
                                if (mascotaCambio != null) {
                                    System.out.print("Nuevo nombre del perro: ");
                                    String nuevoNombre = scanner.nextLine();
                                    personaCambio.cambiarNombreMascota(mascotaCambio.getNombre(), nuevoNombre);
                                    System.out.println("Nombre cambiado.");
                                } else {
                                    System.out.println("Mascota no encontrada.");
                                }
                            } else {
                                System.out.println("Cliente no encontrado.");
                            }
                            error2 = false;
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error, intente de nuevo");
                            guardarExcepcion(e);
                            error2 = true;
                        } catch (CedulaInvalidaException e) {
                            System.out.println("Longitud de cedula invalida, intente de nuevo");
                            guardarExcepcion(e);
                            error2 = true;
                        }
                    }
                    break;
                case 4:
                    centro.mostrarAdopciones();
                    break;
                case 5:
                    try (FileOutputStream fos = new FileOutputStream(filename1); ObjectOutputStream oos = new ObjectOutputStream(fos)){
                        oos.writeObject(centro);
                        System.out.println("Guardado. Bye");
                        return;
                    }
                    catch(IOException e){
                        System.out.println("Error al cargar el objeto en el archivo" + e.getMessage());
                        guardarExcepcion(e);
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }










    }
}
