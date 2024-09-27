package jflex;

public class ErrorReal extends Exception {
    private String mensajeError;
    public ErrorReal(String error) {
        this.mensajeError = error;
    }

    @Override
    public String getMessage() {
        return mensajeError;
    }
}
