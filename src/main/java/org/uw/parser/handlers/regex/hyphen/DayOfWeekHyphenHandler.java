package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;
import org.uw.parser.exception.IncorrectDayInputException;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.exception.NumericInvalidRangeException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfWeekHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int dayFromValue, dayToValue;
    private boolean isNumeric;
    private String dayFromValueText, dayToValueText;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        if(isNumeric(termSplit[0])) {
            dayFromValue = BaseUtil.convertToInt(termSplit[0], term);
            if(hasIncrement)
                dayToValue = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
            else
                dayToValue = BaseUtil.convertToInt(termSplit[1], term);
            if(dayFromValue < 0 || dayFromValue > 7 || dayToValue < 0 || dayToValue > 7)
                throw new NumericOutOfRangeException(dayFromValue, dayToValue, 0, 7, term);

            if(dayFromValue > dayToValue)
                throw new NumericInvalidRangeException(dayFromValue, dayToValue, term);
            isNumeric = true;
        }
        else {
            dayFromValueText = termSplit[0];
            if(hasIncrement)
                dayToValueText = termSplit[1].substring(0, termSplit[1].indexOf('/'));
            else
                dayToValueText = termSplit[1];
            if(!BaseConstants.DAY_OF_WEEK_TERMS.contains(dayFromValueText) || !BaseConstants.DAY_OF_WEEK_TERMS.contains(dayToValueText))
                throw new IncorrectDayInputException(termStr, term);
        }
        if(hasIncrement && (incrementBy > 7 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 7, term);
        }
    }


    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy = 1;

        if(isNumeric){
            for(int i = dayFromValue; i<= dayToValue; i+=incrementBy){
                builder.append(i).append(" ");
            }
        }
        else {
            boolean found = false;
            int j=0;
            for(int i= 0; i < BaseConstants.DAY_OF_WEEK_TERMS.size(); i++){
                if(BaseConstants.DAY_OF_WEEK_TERMS.get(i).equals(dayFromValueText)) {
                    found = true;
                    j = 0;
                }
                if(found && j % incrementBy == 0)
                    builder.append(BaseConstants.DAY_OF_WEEK_TERMS.get(i)).append(" ");
                if(found)
                    j++;

                if(BaseConstants.DAY_OF_WEEK_TERMS.get(i).equals(dayToValueText)) {
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
