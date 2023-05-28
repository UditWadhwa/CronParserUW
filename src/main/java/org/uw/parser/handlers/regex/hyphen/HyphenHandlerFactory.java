package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;

public class HyphenHandlerFactory {

    private static HyphenHandlerFactory factory;

    private HourHyphenHandler hourHyphenHandler;
    private MinuteHyphenHandler minuteHyphenHandler;
    private DayOfMonthHyphenHandler dayOfMonthHyphenHandler;
    private DayOfWeekHyphenHandler dayOfWeekHyphenHandler;
    private MonthHyphenHandler monthHyphenHandler;

    private HyphenHandlerFactory(){
        hourHyphenHandler = new HourHyphenHandler();
        minuteHyphenHandler = new MinuteHyphenHandler();
        dayOfMonthHyphenHandler  = new DayOfMonthHyphenHandler();
        dayOfWeekHyphenHandler = new DayOfWeekHyphenHandler();
        monthHyphenHandler = new MonthHyphenHandler();
    }

    public static HyphenHandlerFactory getInstance(){
        if(factory == null)
            factory = new HyphenHandlerFactory();
        return factory;
    }

    public HyphenHandler getHyphenHandler(Term term){
        switch (term){
            case Hour -> {
                return factory.hourHyphenHandler;
            }
            case Minute -> {
                return factory.minuteHyphenHandler;
            }
            case DayOfMonth -> {
                return factory.dayOfMonthHyphenHandler;
            }
            case DayOfWeek -> {
                return factory.dayOfWeekHyphenHandler;
            }
            case Month -> {
                return factory.monthHyphenHandler;
            }
        };

        return null;
    }

}
