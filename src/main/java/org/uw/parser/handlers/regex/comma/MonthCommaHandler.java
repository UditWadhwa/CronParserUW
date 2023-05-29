package org.uw.parser.handlers.regex.comma;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class MonthCommaHandler extends BaseCommaHandler implements CommaHandler {

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
            if(!BaseConstants.MONTH_TERMS.contains(termSplit[i]))
                throw new Exception(ErrorMessages.INCORRECT_MONTH_TEXTUAL +" Term-" + Term.Month);

            builder.append(termSplit[i]).append(" ");
        }
    }

    private void handleNumeric(String[] termSplit) throws Exception{
        for(int i=0; i< termSplit.length;i++){
            int val = BaseUtil.convertToInt(termSplit[i], Term.DayOfWeek);
            if(val <= 0 || val > 12)
                throw new Exception(ErrorMessages.INCORRECT_MONTH_NUMERIC +" Term-" + Term.Month);

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
