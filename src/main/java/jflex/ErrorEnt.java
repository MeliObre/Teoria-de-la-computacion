package jflex;

public class ErrorEnt extends Exception {
    private String mensajeError;
    public ErrorEnt(String error) {
        this.mensajeError = error;
    }

    @Override
    public String getMessage() {
        return mensajeError;
    }
}
