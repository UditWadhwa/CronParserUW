package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

public class MinuteAsteriskHandler extends BaseAsteriskHandler implements AsteriskHandler{

    private String allMinute;

    public MinuteAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< 60; i++){
            builder.append(i).append(" ");
        }
        allMinute = builder.toString().trim();
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        return allMinute;
    }
}
