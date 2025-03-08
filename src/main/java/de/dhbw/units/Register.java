package de.dhbw.units;

import de.dhbw.exceptions.StorageSlotSizeMismatchException;
import de.dhbw.utils.StorageSlot;

public class Register implements Printable {

    public static final String PREFIX = "r";
    private final StorageSlot[] storageSlots;

    public Register(int registerSize) {
        storageSlots = new StorageSlot[registerSize];
        initRegisterSlots();
    }

    private void initRegisterSlots() {
        for(int i = 0; i < storageSlots.length; i++) {
            storageSlots[i] = new StorageSlot(PREFIX + i);
        }
    }

    public StorageSlot read(Address address) throws IndexOutOfBoundsException {
        int index = checkIndex(address);
        return storageSlots[index];
    }

    public void write(Address address, boolean[] data) throws IndexOutOfBoundsException, StorageSlotSizeMismatchException {
        int index = checkIndex(address);
        storageSlots[index].setValue(data);
    }

    public int getSize() {
        return 0;
    }

    private int checkIndex(Address address) throws IndexOutOfBoundsException {
        if(address.getIndex() < 0 || storageSlots.length <= address.getIndex()) {
            throw new IndexOutOfBoundsException("Address index " + address.getIndex() + " out of bounds for register with length " + storageSlots.length);
        }
        return address.getIndex();
    }

    public String structureToString() {
        String registerSlotsAsString = "";
        for(int i = 0; i < storageSlots.length; i++) {
            registerSlotsAsString += "r" + i + " " + storageSlots[i].toString() + ", ";
        }
        registerSlotsAsString = registerSlotsAsString.substring(0, registerSlotsAsString.length() - 2);
        return registerSlotsAsString;
    }
}
