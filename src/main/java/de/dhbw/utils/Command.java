package de.dhbw.utils;

import de.dhbw.units.Printable;

import java.util.List;

public class Command implements Printable {

    private final String keyword;
    private final List<String> params;

    public Command(String keyword, List<String> params) {
        this.keyword = keyword;
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<String> getParams() {
        return params;
    }

    @Override
    public String structureToString() {
        String result = keyword;
        for(String param : params) {
            result += param;
        }
        return result;
    }
}
