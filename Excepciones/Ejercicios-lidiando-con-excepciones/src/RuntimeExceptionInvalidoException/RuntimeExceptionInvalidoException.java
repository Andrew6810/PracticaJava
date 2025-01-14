package RuntimeExceptionInvalidoException;

public class RuntimeExceptionInvalidoException extends RuntimeException {
    // Usamos el constructor de RuntimeException directamente para pasar el mensaje
    public RuntimeExceptionInvalidoException(String mensaje) {
        super(mensaje);  // Pasamos el mensaje al constructor de la clase base
    }
}

