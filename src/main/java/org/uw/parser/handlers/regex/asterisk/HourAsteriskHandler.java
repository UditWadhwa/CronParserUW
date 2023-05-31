package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.util.BaseUtil;

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
    protected void validate(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        if(hasIncrement && (incrementBy > 23 || incrementBy < 0)){
                throw new InvalidStepRangeException(termStr, 0, 23, term);
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);
        if(!hasIncrement)
            return allHour;
        if(incrementBy == 0)
            incrementBy = 1;

        StringBuilder builder= new StringBuilder();
        for(int i=0; i < 23; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
