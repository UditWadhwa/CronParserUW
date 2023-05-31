package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.data.Term;


public class LastValueHandlerFactory {

    public LastValueHandler getLastValueHandler(Term term){
        switch (term){
            
            case DayOfMonth -> {
                return new DayOfMonthLastValueHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekLastValueHandler();
            }
            
        }

        throw new IllegalArgumentException("Unsupported term.");
    }

}
