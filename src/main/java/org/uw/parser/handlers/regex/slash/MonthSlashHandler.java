package org.uw.parser.handlers.regex.slash;

public class MonthSlashHandler implements SlashHandler {

    private static final String ALL_MONTHS = "1 2 3 4 5 6 7 8 9 10 11 12";

    @Override
    public String process(String term) {
        StringBuilder builder = new StringBuilder();

        String[] termSplit = term.split("/");
        Integer val1 = Integer.parseInt(termSplit[0]);
        Integer val2 = Integer.parseInt(termSplit[1]);
        int i;
        for( i=val1; i<= 12; i+=val2){
            builder.append(i).append(" ");
        }
        i %=12;
        for(; i < val1; i+= val2){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
