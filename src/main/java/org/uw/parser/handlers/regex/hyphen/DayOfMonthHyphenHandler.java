package org.uw.parser.handlers.regex.hyphen;

public class DayOfMonthHyphenHandler implements HyphenHandler {

    private static String ALL_MONTH_DAYS;

    public DayOfMonthHyphenHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i< 32; i++){
            builder.append(i).append(" ");
        }

        builder.deleteCharAt(61);
        ALL_MONTH_DAYS = builder.toString();

    }

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
