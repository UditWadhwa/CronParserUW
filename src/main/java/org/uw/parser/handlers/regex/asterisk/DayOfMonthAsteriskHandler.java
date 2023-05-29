package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class DayOfMonthAsteriskHandler extends BaseAsteriskHandler implements AsteriskHandler{

    private String allMonthDays;

    public DayOfMonthAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i< 32; i++){
            builder.append(i).append(" ");
        }

        builder.deleteCharAt(61);
        allMonthDays = builder.toString().trim();
    }

    @Override
    public void validate(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        if(hasIncrement && (incrementBy > 31 || incrementBy < 0)){
            throw new Exception(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD +" 31" + ". Range-"+ incrementBy
                    + ". Term-"+ term);
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);
        if(!hasIncrement)
            return allMonthDays;
        if(incrementBy == 0)
            incrementBy = 1;

        StringBuilder builder= new StringBuilder();
        for(int i=1; i <= 31; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }

}
