package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;

public class SlashHandlerFactory {

    private static SlashHandlerFactory factory;

    private HourSlashHandler hourSlashHandler;
    private MinuteSlashHandler minuteSlashHandler;
    private DayOfMonthSlashHandler dayOfMonthSlashHandler;
    private DayOfWeekSlashHandler dayOfWeekSlashHandler;
    private MonthSlashHandler monthSlashHandler;

    private SlashHandlerFactory(){
        hourSlashHandler = new HourSlashHandler();
        minuteSlashHandler = new MinuteSlashHandler();
        dayOfMonthSlashHandler  = new DayOfMonthSlashHandler();
        dayOfWeekSlashHandler = new DayOfWeekSlashHandler();
        monthSlashHandler = new MonthSlashHandler();
    }

    public static SlashHandlerFactory getInstance(){
        if(factory == null)
            factory = new SlashHandlerFactory();
        return factory;
    }

    public SlashHandler getSlashHandler(Term term){
        switch (term){
            case Hour -> {
                return factory.hourSlashHandler;
            }
            case Minute -> {
                return factory.minuteSlashHandler;
            }
            case DayOfMonth -> {
                return factory.dayOfMonthSlashHandler;
            }
            case DayOfWeek -> {
                return factory.dayOfWeekSlashHandler;
            }
            case Month -> {
                return factory.monthSlashHandler;
            }
        };

        return null;
    }

}
