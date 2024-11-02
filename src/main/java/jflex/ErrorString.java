package jflex;

public class ErrorString extends RuntimeException {
    private String mensajeError;
    public ErrorString(String error) {
        this.mensajeError = error;
    }

    @Override
    public String getMessage() {
        return mensajeError;
    }
}
