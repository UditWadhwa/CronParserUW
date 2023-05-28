package org.uw.parser.handlers.regex.comma;

public class MonthCommaHandler implements CommaHandler {

    private static final String ALL_MONTHS = "1 2 3 4 5 6 7 8 9 10 11 12";

    @Override
    public String process(String term) {
        return ALL_MONTHS;
    }
}
