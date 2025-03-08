package de.dhbw.units.operators;

import de.dhbw.exceptions.NotImplementedException;
import de.dhbw.utils.StorageSlot;

import java.util.List;

public class SubtractOperator extends Operator {

    public SubtractOperator() {
        super("sub");
    }

    @Override
    public OperatorResult process(List<StorageSlot> operationStorageSlots) throws NotImplementedException {
        OperatorResult.OperatorResultBuilder operatorResultBuilder = new OperatorResult.OperatorResultBuilder();

        //if(2 == operationStorageSlots.size()) {
        boolean[] op2Value = operationStorageSlots.get(1).getValue();
        boolean[] op1Value = operationStorageSlots.get(0).getValue();
        int valueSize = op1Value.length;
        boolean[] result = new boolean[valueSize];
        boolean borrow = false;

        for (int i = valueSize - 1; i >= 0; i--) {
            boolean a = op1Value[i];
            boolean b = op2Value[i];

            // Subtraktion mit Borrow: a - b - borrow
            result[i] = (a ^ b) ^ borrow;
            borrow = (!a && (b || borrow)) || (b && borrow);
        }

        operatorResultBuilder.setValue(result);
        if(borrow) {
            operatorResultBuilder.addFlag(Flag.OVERFLOW);
        }
        return operatorResultBuilder.build();
    }
}
