package universities;
import java.util.ArrayList;
import java.util.List;
public class Student {
    private long code;
    private long id;
    private String name;
    private String facultad;
    private List<Class>classes=new ArrayList<>();

    public Student(long code,long id,String name,String facultad)
    {
        this.code=code;
        this.id=id;
        this.name=name;
        this.facultad=facultad;
    }

    public long getCode() {
        return code;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFacultad() {
        return facultad;
    }
    public void inscribirClase(Class c)
    {
        classes.add(c);
    }
    public List<Class> getClasses() {
        return classes;
    }
}