package de.dhbw.units;

import de.dhbw.utils.CommandType;

import java.util.List;

public class CommandRegister {

    private final List<CommandType> commandTypeList;

    private CommandRegister(List<CommandType> commandTypeList) {
        this.commandTypeList = commandTypeList;
    }

    public class CommandRegisterBuilder {

        private List<CommandType> commandTypeList;

    }

}
