package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class MonthHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int val1, val2;
    private boolean isNumeric;
    private String month1, month2;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        if(isNumeric(termSplit[0])) {
            val1 = BaseUtil.convertToInt(termSplit[0], term);
            if(hasIncrement)
                val2 = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
            else
                val2 = BaseUtil.convertToInt(termSplit[1], term);
            if(val1 <= 0 || val1>12 || val2 <= 0 || val2 > 12)
                throw new Exception(String.format(ErrorMessages.INVALID_OPERANDS_HYPHEN, val1, val2, term, 1, 12));
            if(val1 > val2)
                throw new Exception(String.format(ErrorMessages.INCORRECT_HYPHEN_RANGE_FROM, val1, val2, term));
            isNumeric = true;
        }
        else {
            month1 = termSplit[0];
            if(hasIncrement)
                month2 = termSplit[1].substring(0, termSplit[1].indexOf('/'));
            else
                month2 = termSplit[1];
            if(!BaseConstants.MONTH_TERMS.contains(month1) || !BaseConstants.MONTH_TERMS.contains(month2))
                throw new Exception(ErrorMessages.INVALID_OPERANDS + " Term- " + term.toString());
        }
        if(hasIncrement && (incrementBy > 12 || incrementBy < 0)){
            throw new Exception(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD + "12" + ". Range-"+ incrementBy +
                    ". Term-"+term);
        }
    }


    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy =1;
        if(isNumeric){
            for(int i=val1; i<=val2; i+= incrementBy){
                builder.append(i).append(" ");
            }
        }
        else {
            boolean found  = false;
            for(int i= 0; i < BaseConstants.MONTH_TERMS.size(); i+=incrementBy){
                if(BaseConstants.MONTH_TERMS.get(i).equals(month1))
                    found= true;

                if(found)
                    builder.append(BaseConstants.MONTH_TERMS.get(i)).append(" ");

                if(BaseConstants.MONTH_TERMS.get(i).equals(month2))
                    break;
            }
        }

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
