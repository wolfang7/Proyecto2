package universities;

public class CategoriaInvalidaException extends Exception {
    private String message;
    public CategoriaInvalidaException(String message) {
        super(message);
    }
}
