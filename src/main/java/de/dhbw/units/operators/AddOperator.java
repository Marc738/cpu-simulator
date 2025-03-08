package de.dhbw.units.operators;

import de.dhbw.exceptions.NotImplementedException;
import de.dhbw.utils.StorageSlot;

import java.util.List;

public class AddOperator extends Operator {

    public AddOperator() {
        super("add");
    }

    @Override
    public OperatorResult process(List<StorageSlot> operationStorageSlots) throws NotImplementedException {
        OperatorResult.OperatorResultBuilder operatorResultBuilder = new OperatorResult.OperatorResultBuilder();

        boolean[] op2Value = operationStorageSlots.get(1).getValue();
        boolean[] op1Value = operationStorageSlots.get(0).getValue();
        int valueSize = op1Value.length;
        boolean[] result = new boolean[valueSize];
        boolean carry = false;

        for (int i = valueSize - 1; i >= 0; i--) {
            boolean sum = op1Value[i] ^ op2Value[i] ^ carry;
            carry = (op1Value[i] && op2Value[i]) || (carry && (op1Value[i] ^ op2Value[i]));
            result[i] = sum;
        }

        operatorResultBuilder.setValue(result);
        boolean overflow = (op1Value[0] == op2Value[0]) && (result[0] != op1Value[0]);

        if (overflow) {
            operatorResultBuilder.addFlag(Flag.OVERFLOW);
        }
        return operatorResultBuilder.build();
    }
}
