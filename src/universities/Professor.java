public abstract class Professor {
    protected String name;
    protected String id;

    public Professor(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateSalary();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
