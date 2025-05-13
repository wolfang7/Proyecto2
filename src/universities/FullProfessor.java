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
        switch(category)
        {
            case ASSISTANT: return SALARIOBASE;
            case ASSOCIATE: return SALARIOBASE*2;
            case REGULAR: return SALARIOBASE*5;
            default: return SALARIOBASE;

        }

    }

    public ProfessorCategory getCategory() {
        return category;
    }
}