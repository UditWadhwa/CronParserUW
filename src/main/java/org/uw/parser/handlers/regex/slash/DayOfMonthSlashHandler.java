package org.uw.parser.handlers.regex.slash;

public class DayOfMonthSlashHandler implements SlashHandler {

    private static String ALL_MONTH_DAYS;

    public DayOfMonthSlashHandler(){
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

        String[] termSplit = term.split("/");
        Integer val1 = Integer.parseInt(termSplit[0]);
        Integer val2 = Integer.parseInt(termSplit[1]);
        int i;
        for( i=val1; i<= 31; i+=val2){
            builder.append(i).append(" ");
        }
        i %=31;
        for(; i < val1; i+= val2){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
