package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.data.Term;


public class LastValueHandlerFactory {

    private static LastValueHandlerFactory factory;

    private DayOfMonthLastValueHandler dayOfMonthLastValueHandler;
    private DayOfWeekLastValueHandler dayOfWeekLastValueHandler;


    private LastValueHandlerFactory(){
        dayOfMonthLastValueHandler  = new DayOfMonthLastValueHandler();
        dayOfWeekLastValueHandler = new DayOfWeekLastValueHandler();
    }

    public static LastValueHandlerFactory getInstance(){
        if(factory == null)
            factory = new LastValueHandlerFactory();
        return factory;
    }

    public LastValueHandler getLastValueHandler(Term term){
        switch (term){
            
            case DayOfMonth -> {
                return factory.dayOfMonthLastValueHandler;
            }
            case DayOfWeek -> {
                return factory.dayOfWeekLastValueHandler;
            }
            
        }

        return null;
    }

}
