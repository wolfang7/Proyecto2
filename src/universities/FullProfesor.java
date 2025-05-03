package universities;
public class FullProfessor extends Professor {

    private static final double SALARIOBASE = 600;
    private ProfessorCategory category;

    public FullProfessor(String email, String name, ProfessorCategory category) {
        super(email, name);
        this.category = category;
    }

    @Override
    public double calcularSalario() {
        return SALARIOBASE;
    }

    public ProfessorCategory getCategory() {
        return category;
    }
}
