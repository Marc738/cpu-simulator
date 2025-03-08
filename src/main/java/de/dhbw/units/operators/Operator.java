package de.dhbw.units.operators;

import de.dhbw.exceptions.NotImplementedException;
import de.dhbw.utils.Command;
import de.dhbw.utils.StorageSlot;

import java.util.List;

public class Operator {
    private String keyword;

    public Operator(String keyword) {
        this.keyword = keyword;
    }

    public boolean canProcess(Command command) throws NotImplementedException {
        return (command.getKeyword().contentEquals(keyword));
    }

    public OperatorResult process(List<StorageSlot> operationStorageSlots) throws NotImplementedException {
        throw new NotImplementedException("Operator.process of prefix " + keyword + " not implemented!");
    }

}
