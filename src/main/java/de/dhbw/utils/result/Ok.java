package de.dhbw.utils.result;

public class Ok<T> extends Result<T> {

    private T value;

    public Ok(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
