package universities;


public class TipoDeProfessorInvalidoException extends Exception {
    private String message;
    public TipoDeProfessorInvalidoException(String message) {
        super(message);
    }
}