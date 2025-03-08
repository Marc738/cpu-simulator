package de.dhbw.units.operators;

public class OperatorParameter {
    private String address;
    private boolean[] value;

    public OperatorParameter(String address) {
        this.address = address;
    }

    public OperatorParameter(boolean[] value) {
        this.value = value;
    }

    public void setValue(boolean[] value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public boolean[] getValue() {
        return value;
    }
}
