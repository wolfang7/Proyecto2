package universities;
public abstract class Professor {
    protected long email;
    protected String name;

    public Professor(long email, String name) {
        this.email = email;
        this.name = name;
    }

    public long getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public abstract double calcularSalario();
}