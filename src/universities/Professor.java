package universities;
public abstract class Professor {
    protected String email;
    protected String name;

    public Professor(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public abstract double calcularSalario();
}