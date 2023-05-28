package org.uw.parser.handlers.regex.hyphen;

public class MonthHyphenHandler implements HyphenHandler {

    private static final String ALL_MONTHS = "1 2 3 4 5 6 7 8 9 10 11 12";

    @Override
    public String process(String term) {
        StringBuilder builder = new StringBuilder();

        String[] termSplit = term.split("-");
        Integer val1 = Integer.parseInt(termSplit[0]);
        Integer val2 = Integer.parseInt(termSplit[1]);

        for(int i=val1; i<=val2; i++){
            builder.append(i).append(" ");
        }
        return builder.toString().trim();

    }
}
