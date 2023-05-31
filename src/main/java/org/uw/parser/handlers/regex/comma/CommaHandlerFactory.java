package org.uw.parser.handlers.regex.comma;

import org.uw.parser.data.Term;

public class CommaHandlerFactory {
    public CommaHandler getCommaHandler(Term term){
        switch (term){
            case Hour -> {
                return new HourCommaHandler();
            }
            case Minute -> {
                return new MinuteCommaHandler();
            }
            case DayOfMonth -> {
                return new DayOfMonthCommaHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekCommaHandler();
            }
            case Month -> {
                return new MonthCommaHandler();
            }
        };

        return null;
    }

}
