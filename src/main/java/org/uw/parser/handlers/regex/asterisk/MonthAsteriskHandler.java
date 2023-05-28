package org.uw.parser.handlers.regex.asterisk;

public class MonthAsteriskHandler implements AsteriskHandler{

    private static final String ALL_MONTHS = "1 2 3 4 5 6 7 8 9 10 11 12";

    @Override
    public String process() {
        return ALL_MONTHS;
    }
}
