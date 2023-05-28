package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

public class AsteriskHandlerFactory {

    private static AsteriskHandlerFactory factory;

    private HourAsteriskHandler hourAsteriskHandler;
    private MinuteAsteriskHandler minuteAsteriskHandler;
    private DayOfMonthAsteriskHandler dayOfMonthAsteriskHandler;
    private DayOfWeekAsteriskHandler dayOfWeekAsteriskHandler;
    private MonthAsteriskHandler monthAsteriskHandler;

    private AsteriskHandlerFactory(){
        hourAsteriskHandler = new HourAsteriskHandler();
        minuteAsteriskHandler = new MinuteAsteriskHandler();
        dayOfMonthAsteriskHandler  = new DayOfMonthAsteriskHandler();
        dayOfWeekAsteriskHandler = new DayOfWeekAsteriskHandler();
        monthAsteriskHandler = new MonthAsteriskHandler();
    }

    public static AsteriskHandlerFactory getInstance(){
        if(factory == null)
            factory = new AsteriskHandlerFactory();
        return factory;
    }

    public AsteriskHandler getAsteriskHandler(Term term){
        switch (term){
            case Hour -> {
                return factory.hourAsteriskHandler;
            }
            case Minute -> {
                return factory.minuteAsteriskHandler;
            }
            case DayOfMonth -> {
                return factory.dayOfMonthAsteriskHandler;
            }
            case DayOfWeek -> {
                return factory.dayOfWeekAsteriskHandler;
            }
            case Month -> {
                return factory.monthAsteriskHandler;
            }
        };

        return null;
    }

}
