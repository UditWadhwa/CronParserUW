package org.uw.parser.handlers;

public class CommandHandler extends BaseTermHandler implements TermHandler{

    public CommandHandler(){
        super();
    }

    @Override
    public String process(String term) throws Exception {
        StringBuilder builder = new StringBuilder("command \t");
        builder.append(term);
        return builder.toString();
    }

    @Override
    public void preProcess() {

    }
}
