package universities;

import java.util.ArrayList;
import java.util.List;

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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}