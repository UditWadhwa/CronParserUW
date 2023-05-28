package org.uw.parser.handlers.regex.asterisk;

public class DayOfWeekAsteriskHandler implements AsteriskHandler{
    private static String ALL_DAYS;

    public DayOfWeekAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<= 7; i++){
            builder.append(i).append(" ");
        }

        builder.deleteCharAt(13);
        ALL_DAYS = builder.toString();

    }

    @Override
    public String process() {
        return ALL_DAYS;
    }
}
