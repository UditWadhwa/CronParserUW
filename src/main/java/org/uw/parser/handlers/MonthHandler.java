package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class MonthHandler extends BaseTermHandler implements TermHandler{

    public MonthHandler() {
        super();
    }

    @Override
    public String process(String term) throws Exception{
        StringBuilder builder = new StringBuilder("month \t");
        if(term.contains("/"))
            return builder.append(this.slashHandlerFactory.getSlashHandler(Term.Month).process(term)).toString();
        else if(term.contains("-"))
            return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.Month).process(term)).toString();
        return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Month).process()).toString();
    }

    @Override
    public void preProcess() {

    }
}
