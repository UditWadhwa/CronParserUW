package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class MonthAsteriskHandler extends  BaseAsteriskHandler implements AsteriskHandler{

    private String allMonth;

    public MonthAsteriskHandler(){
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<= 12; i++){
            builder.append(i).append(" ");
        }
        allMonth = builder.toString().trim();
    }

    @Override
    public void validate(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        if(hasIncrement && (incrementBy > 12 || incrementBy < 0)){
            throw new Exception(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD + "12" + ". Range-"+ incrementBy +
                    ". Term-"+term);
        }
    }
    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        if(!hasIncrement)
            return allMonth;
        if(incrementBy == 0)
            incrementBy = 1;

        StringBuilder builder= new StringBuilder();
        for(int i=1; i <= 12; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
