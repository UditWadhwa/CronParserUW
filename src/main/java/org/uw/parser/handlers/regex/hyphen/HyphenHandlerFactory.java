package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;

public class HyphenHandlerFactory {

    public HyphenHandler getHyphenHandler(Term term){
        switch (term){
            case Hour -> {
                return new HourHyphenHandler();
            }
            case Minute -> {
                return new MinuteHyphenHandler();
            }
            case DayOfMonth -> {
                return new DayOfMonthHyphenHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekHyphenHandler();
            }
            case Month -> {
                return new MonthHyphenHandler();
            }
        };

        return null;
    }

}
