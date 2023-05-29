package org.uw.parser.handlers.regex.comma;

import org.uw.parser.data.Term;

public class CommaHandlerFactory {

    private static CommaHandlerFactory factory;

    private HourCommaHandler hourCommaHandler;
    private MinuteCommaHandler minuteCommaHandler;
    private DayOfMonthCommaHandler dayOfMonthCommaHandler;
    private DayOfWeekCommaHandler dayOfWeekCommaHandler;
    private MonthCommaHandler monthCommaHandler;

    private CommaHandlerFactory(){
        hourCommaHandler = new HourCommaHandler();
        minuteCommaHandler = new MinuteCommaHandler();
        dayOfMonthCommaHandler  = new DayOfMonthCommaHandler();
        dayOfWeekCommaHandler = new DayOfWeekCommaHandler();
        monthCommaHandler = new MonthCommaHandler();
    }

    public static CommaHandlerFactory getInstance(){
        if(factory == null)
            factory = new CommaHandlerFactory();
        return factory;
    }

    public CommaHandler getCommaHandler(Term term){
        switch (term){
            case Hour -> {
                return factory.hourCommaHandler;
            }
            case Minute -> {
                return factory.minuteCommaHandler;
            }
            case DayOfMonth -> {
                return factory.dayOfMonthCommaHandler;
            }
            case DayOfWeek -> {
                return factory.dayOfWeekCommaHandler;
            }
            case Month -> {
                return factory.monthCommaHandler;
            }
        };

        return null;
    }

}
