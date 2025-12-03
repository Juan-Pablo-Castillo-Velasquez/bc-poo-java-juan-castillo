package CreatividadDigital.Excepciones;

public class FechaInvalidaException extends Exception {

    public FechaInvalidaException() {
        super("La fecha debe estar en formato YYYY-MM-DD.");
    }

    public FechaInvalidaException(String message) {
        super(message);
    }
}
