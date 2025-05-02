package universities;

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

    }
}
