package dio.com.br.klinic.exception;

public class CpfInUseException extends RuntimeException {
    public CpfInUseException(String message) {
        super(message);
    }
}
