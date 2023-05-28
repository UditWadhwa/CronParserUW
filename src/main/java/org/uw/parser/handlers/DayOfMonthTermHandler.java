package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class DayOfMonthTermHandler extends BaseTermHandler implements TermHandler{

    public DayOfMonthTermHandler() {
        super();
    }

    @Override
    public String process(String term) throws Exception{
        StringBuilder builder = new StringBuilder("day of month \t");
        if(term.contains("/"))
            return builder.append(this.slashHandlerFactory.getSlashHandler(Term.DayOfMonth).process(term)).toString();
        else if(term.contains("-"))
            return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.DayOfMonth).process(term)).toString();
        return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.DayOfMonth).process()).toString();
    }

    @Override
    public void preProcess() {

    }
}
