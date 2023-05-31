package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;

public class SlashHandlerFactory {

    public SlashHandler getSlashHandler(Term term){
        switch (term){
            case Hour -> {
                return new HourSlashHandler();
            }
            case Minute -> {
                return new MinuteSlashHandler();
            }
            case DayOfMonth -> {
                return new DayOfMonthSlashHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekSlashHandler();
            }
            case Month -> {
                return new MonthSlashHandler();
            }
        };

        return null;
    }

}
