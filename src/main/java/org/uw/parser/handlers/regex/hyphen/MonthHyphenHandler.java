package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;
import org.uw.parser.exception.IncorrectMonthInputException;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.exception.NumericInvalidRangeException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class MonthHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int monthFromValue, monthToValue;
    private boolean isNumeric;
    private String monthFromValueText, monthToValueText;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        if(isNumeric(termSplit[0])) {
            monthFromValue = BaseUtil.convertToInt(termSplit[0], term);
            if(hasIncrement)
                monthToValue = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
            else
                monthToValue = BaseUtil.convertToInt(termSplit[1], term);
            if(monthFromValue <= 0 || monthFromValue >12 || monthToValue <= 0 || monthToValue > 12)
                throw new NumericOutOfRangeException(monthFromValue, monthToValue, 1, 12, term);
            if(monthFromValue > monthToValue)
                throw new NumericInvalidRangeException(monthFromValue, monthToValue, term);
            isNumeric = true;
        }
        else {
            monthFromValueText = termSplit[0];
            if(hasIncrement)
                monthToValueText = termSplit[1].substring(0, termSplit[1].indexOf('/'));
            else
                monthToValueText = termSplit[1];
            if(!BaseConstants.MONTH_TERMS.contains(monthFromValueText) || !BaseConstants.MONTH_TERMS.contains(monthToValueText))
                throw new IncorrectMonthInputException(termStr, term);
        }
        if(hasIncrement && (incrementBy > 12 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 12, term);
        }
    }


    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy =1;
        if(isNumeric){
            for(int i = monthFromValue; i<= monthToValue; i+= incrementBy){
                builder.append(i).append(" ");
            }
        }
        else {
            boolean found = false;
            int j=0;
            for(int i= 0; i < BaseConstants.MONTH_TERMS.size(); i++){
                if(BaseConstants.MONTH_TERMS.get(i).equals(monthFromValueText)) {
                    found = true;
                    j = 0;
                }
                if(found && j % incrementBy == 0)
                    builder.append(BaseConstants.MONTH_TERMS.get(i)).append(" ");
                if(found)
                    j++;

                if(BaseConstants.MONTH_TERMS.get(i).equals(monthToValueText)) {
                    break;
                }
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
