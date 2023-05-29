package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
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
    public void validate(String termStr, Term term) throws Exception{
        super.validate(termStr, term);
        if(hasIncrement && (incrementBy > 59 || incrementBy < 0)){
            throw new Exception(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD + "59" + ". Range-"+ incrementBy +
                    ". Term-"+term);
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        if(!hasIncrement)
            return allMinute;
        if(incrementBy == 0)
            incrementBy = 1;

        StringBuilder builder= new StringBuilder();
        for(int i=0; i < 59; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
