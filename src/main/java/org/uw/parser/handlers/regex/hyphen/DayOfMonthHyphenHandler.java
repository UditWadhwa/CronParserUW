package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.exception.NumericInvalidRangeException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfMonthHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int monthFromValue, monthToValue;


    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");

            monthFromValue = BaseUtil.convertToInt(termSplit[0], term);
            if(hasIncrement)
                monthToValue = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
            else
                monthToValue = BaseUtil.convertToInt(termSplit[1], term);
            if(monthFromValue <= 0 || monthFromValue > 31 || monthToValue <= 0 || monthToValue > 31)
                throw new NumericOutOfRangeException(monthFromValue, monthToValue, 1, 31, term);
            if(monthFromValue > monthToValue)
                throw new NumericInvalidRangeException(monthFromValue, monthToValue, term);

        if(hasIncrement && (incrementBy > 31 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 31, Term.DayOfMonth);
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy =1;

        for(int i = monthFromValue; i<= monthToValue; i+=incrementBy){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }

}
