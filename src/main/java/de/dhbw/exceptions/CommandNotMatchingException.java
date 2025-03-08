package de.dhbw.exceptions;

import de.dhbw.units.CommandRegister;

public class CommandNotMatchingException extends Exception {
    public CommandNotMatchingException(String e) {
        super(e);
    }
}
