package co.com.k4soft.parqueadero.model.businessexception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public BusinessException(String mensaje) {
        super(mensaje);
    }
}
