package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class DayOfWeekTermHandler extends BaseTermHandler implements TermHandler{
    public DayOfWeekTermHandler() {
        super();
    }

    @Override
    public String process(String term) throws Exception{
        StringBuilder builder = new StringBuilder("day of week \t");
        if(term.contains("/")){
            return builder.append(this.slashHandlerFactory.getSlashHandler(Term.DayOfWeek).process(term)).toString();
        }
        else if(term.contains("-"))
            return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.DayOfWeek).process(term)).toString();
        return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.DayOfWeek).process()).toString();
    }

    @Override
    public void preProcess() {

    }
}
