package org.uw.parser.handlers.regex.hyphen;

public class DayOfWeekHyphenHandler implements HyphenHandler {
    private static String ALL_DAYS;

    public DayOfWeekHyphenHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<= 7; i++){
            builder.append(i).append(" ");
        }

        builder.deleteCharAt(13);
        ALL_DAYS = builder.toString();

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
