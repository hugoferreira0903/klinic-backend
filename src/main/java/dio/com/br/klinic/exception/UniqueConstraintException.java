package dio.com.br.klinic.exception;

public class UniqueConstraintException extends RuntimeException {
    public UniqueConstraintException(String message) {
        super(message);
    }
}
