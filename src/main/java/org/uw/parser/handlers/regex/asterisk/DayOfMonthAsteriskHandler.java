package org.uw.parser.handlers.regex.asterisk;

public class DayOfMonthAsteriskHandler implements AsteriskHandler{

    private static String ALL_MONTH_DAYS;
    private static int FINAL_DAY_OF_MONTH;

    public DayOfMonthAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i< 32; i++){
            builder.append(i).append(" ");
        }

        builder.deleteCharAt(61);
        ALL_MONTH_DAYS = builder.toString();

    }



    @Override
    public String process() {
        return ALL_MONTH_DAYS;
    }
}
