package de.dhbw.utils;

import de.dhbw.exceptions.CommandNotMatchingException;
import de.dhbw.units.UnitType;
import de.dhbw.utils.result.Error;
import de.dhbw.utils.result.Ok;
import de.dhbw.utils.result.Result;

public class CommandType {

    private final String keyword;
    private final int paramSize;
    private final UnitType unitType;

    public CommandType(String keyword, int paramSize, UnitType unitType) {
        this.keyword = keyword;
        this.paramSize = paramSize;
        this.unitType = unitType;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getParamSize() {
        return paramSize;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public Result<UnitType> canProcess(Command command) {
        if(command.getKeyword().contentEquals(keyword) && command.getParams().size() == paramSize) {
            return new Ok<UnitType>(unitType);
        } else {
            return new Error<UnitType>(new CommandNotMatchingException("Command " + command.toString()));
        }
    }

}
