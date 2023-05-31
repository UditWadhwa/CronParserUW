package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

public class AsteriskHandlerFactory {

    public AsteriskHandler getAsteriskHandler(Term term){
        switch (term){
            case Hour -> {
                return new HourAsteriskHandler();
            }
            case Minute -> {
                return new MinuteAsteriskHandler();
            }
            case DayOfMonth -> {
                return new DayOfMonthAsteriskHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekAsteriskHandler();
            }
            case Month -> {
                return new MonthAsteriskHandler();
            }
        };

        return null;
    }

}
