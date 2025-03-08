package de.dhbw.units.operators;

import de.dhbw.utils.StorageSlot;

import java.util.ArrayList;
import java.util.List;

public class OperatorResult {
    private boolean[] value;
    private List<Flag> flags;

    private OperatorResult(OperatorResultBuilder operatorResultBuilder) {
        value = operatorResultBuilder.getValue();
        flags = operatorResultBuilder.getFlags();
    }

    private boolean[] getValue() {
        return value;
    }

    private List<Flag> getFlags() {
        return flags;
    }

    public static class OperatorResultBuilder {
        private boolean[] value;
        private List<Flag> flags;

        public OperatorResultBuilder() {
            value = new boolean[StorageSlot.BIT_SIZE];
            flags = new ArrayList<Flag>();
        }

        public void setValue(boolean[] value) {
            this.value = value;
        }

        private boolean[] getValue() {
            return value;
        }

        public void addFlag(Flag flag) {
            flags.add(flag);
        }

        private List<Flag> getFlags() {
            return flags;
        }

        public OperatorResult build() {
            return new OperatorResult(this);
        }
    }
}
