package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

public class HourAsteriskHandler extends BaseAsteriskHandler implements AsteriskHandler{
    private String allHour;

    public HourAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< 24; i++){
            builder.append(i).append(" ");
        }

        allHour = builder.toString().trim();

    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        return allHour;
    }
}
