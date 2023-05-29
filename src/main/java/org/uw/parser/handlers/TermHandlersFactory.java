package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class TermHandlersFactory {

    private MonthTermHandler monthHandler;
    private DayOfMonthTermHandler dayOfMonthTermHandler;
    private CommandHandler commandHandler;
    private DayOfWeekTermHandler dayOfWeekTermHandler;
    private HourTermHandler hourTermHandler;
    private MinuteTermHandler minuteTermHandler;

    private TermHandlersFactory(){
        //factory = new TermHandlersFactory();
        monthHandler = new MonthTermHandler();
        dayOfWeekTermHandler = new DayOfWeekTermHandler();
        dayOfMonthTermHandler = new DayOfMonthTermHandler();
        commandHandler = new CommandHandler();
        hourTermHandler = new HourTermHandler();
        minuteTermHandler = new MinuteTermHandler();
    }

    private static TermHandlersFactory factory;

    public static TermHandlersFactory getInstance(){
        if(factory == null)
            factory = new TermHandlersFactory();

        return factory;
    }

    public TermHandler getTermHandler(Term term){
        switch (term){
            case Hour -> {
                return hourTermHandler;
            }
            case Month -> {
                return monthHandler;
            }
            case DayOfMonth -> {
                return dayOfMonthTermHandler;
            }
            case DayOfWeek -> {
                return dayOfWeekTermHandler;
            }
            case Minute -> {
                return minuteTermHandler;
            }
            case Command -> {
                return commandHandler;
            }

        };

        return null;
    }

}
