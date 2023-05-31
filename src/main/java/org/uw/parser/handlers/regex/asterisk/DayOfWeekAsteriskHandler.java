package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidStepRangeException;

public class DayOfWeekAsteriskHandler extends BaseAsteriskHandler implements AsteriskHandler{

    private String allDays;

    public DayOfWeekAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<= 7; i++){
            builder.append(i).append(" ");
        }
        builder.deleteCharAt(13);
        allDays = builder.toString().trim();

    }

    @Override
    protected void validate(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        if(hasIncrement && (incrementBy > 7 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 7, term);
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);
        if(!hasIncrement)
            return allDays;
        if(incrementBy == 0)
            incrementBy = 1;

        StringBuilder builder= new StringBuilder();
        for(int i=1; i <= 7; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
