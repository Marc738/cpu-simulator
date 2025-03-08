package de.dhbw.utils.result;

public class Error<T> extends Result<T> {

    private Exception e;

    public Error(Exception e) {
        this.e = e;
    }

    public Exception getException() {
        return e;
    }

}
