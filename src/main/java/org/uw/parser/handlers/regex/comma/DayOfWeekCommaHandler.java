package org.uw.parser.handlers.regex.comma;

import org.uw.parser.data.Term;
import org.uw.parser.exception.IncorrectDayInputException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfWeekCommaHandler extends  BaseCommaHandler implements CommaHandler {

    private StringBuilder builder;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);

        builder = new StringBuilder();
        String[] termSplit = termStr.split("\\,");

        if(isNumeric(termSplit[0]))
            handleNumeric(termSplit);
        else
            handleTextual(termSplit);
    }

    private void handleTextual(String[] termSplit) throws Exception{
        for(int i=0; i< termSplit.length;i++){
            if(!BaseConstants.DAY_OF_WEEK_TERMS.contains(termSplit[i]))
                throw new IncorrectDayInputException(termSplit[i], Term.DayOfWeek);

            builder.append(termSplit[i]).append(" ");
        }
    }

    private void handleNumeric(String[] termSplit) throws Exception{
        for(int i=0; i< termSplit.length;i++){
            int val = BaseUtil.convertToInt(termSplit[i], Term.DayOfWeek);
            if(val < 0 || val > 7)
                throw new NumericOutOfRangeException(termSplit[i], 0, 7, Term.DayOfWeek);

            builder.append(val).append(" ");
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);
        return builder.toString().trim();
    }



    private boolean isNumeric(String term){

        try{
            Integer.parseInt(term);
        }
        catch (Exception e){
           return false;
        }

        return true;
    }
}
