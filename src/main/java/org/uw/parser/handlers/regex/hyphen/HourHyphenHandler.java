package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.exception.NumericInvalidRangeException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseUtil;

public class HourHyphenHandler extends BaseHyphenHandler implements HyphenHandler {
    private int hourFromValue, hourToValue;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        hourFromValue = BaseUtil.convertToInt(termSplit[0], term);
        if(hasIncrement)
            hourToValue = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
        else
            hourToValue = BaseUtil.convertToInt(termSplit[1], term);
        if(hourFromValue < 0 || hourFromValue > 23 || hourToValue < 0 || hourToValue > 23)
            throw new NumericOutOfRangeException(hourFromValue, hourToValue, 0, 23, term);
        if(hourFromValue > hourToValue)
            throw new NumericInvalidRangeException(hourFromValue, hourToValue, term);

        if(hasIncrement && (incrementBy > 23 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 23, term);
        }

    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy =1;

        for(int i = hourFromValue; i<= hourToValue; i+=incrementBy){
            builder.append(i).append(" ");
        }
        return builder.toString().trim();
    }
}
