package org.uw.parser.handlers;

import org.uw.parser.data.Term;

public class HourTermHandler extends BaseTermHandler implements TermHandler{

    public HourTermHandler() {
        super();
    }

    @Override
    public String process(String term) throws Exception{
        StringBuilder builder = new StringBuilder("hour \t");
        if(term.contains("/")){
            builder.append(this.slashHandlerFactory.getSlashHandler(Term.Hour).process(term)).toString();
        }
        else if(term.contains("-"))
            builder.append(this.slashHandlerFactory.getSlashHandler(Term.Hour).process(term)).toString();
        return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Hour).process()).toString();

        //return null;
    }

    @Override
    public void preProcess() {

    }
}
