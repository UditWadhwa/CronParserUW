package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class TermHandlersFactory {
    public TermHandler getTermHandler(Term term){
        switch (term){
            case Hour -> {
                return new HourTermHandler();
            }
            case Month -> {
                return new MonthTermHandler();
            }
            case DayOfMonth -> {
                return new DayOfMonthTermHandler();
            }
            case DayOfWeek -> {
                return new DayOfWeekTermHandler();
            }
            case Minute -> {
                return new MinuteTermHandler();
            }
            case Command -> {
                return new CommandHandler();
            }

        };

        return null;
    }

}
