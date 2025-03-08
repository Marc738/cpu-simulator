package de.dhbw.utils;

import de.dhbw.exceptions.StorageSlotSizeMismatchException;
import de.dhbw.units.Printable;

public class StorageSlot implements Printable {
    public final static int BIT_SIZE = 8;

    private String name;
    private boolean[] value;

    public StorageSlot(String name) {
        this.name = name;
        value = new boolean[BIT_SIZE];
    }

    public String getName() {
        return name;
    }

    public StorageSlot(boolean[] value) throws StorageSlotSizeMismatchException {
        if(value.length == BIT_SIZE) {
            value = value;
        } else {
            throw new StorageSlotSizeMismatchException("Init value had size " + value.length + ", but BIT_SIZE is " + BIT_SIZE);
        }
    }

    public boolean[] getValue() {
        return value;
    }

    public void setValue(boolean[] value) throws StorageSlotSizeMismatchException {
        if(value.length == BIT_SIZE) {
            this.value = value;
        } else {
            throw new StorageSlotSizeMismatchException("Init value had size " + value.length + ", but BIT_SIZE is " + BIT_SIZE);
        }
    }

    @Override
    public String structureToString() {
        String result = "[";
        for(boolean bit : value) {
            if(bit) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }
}
