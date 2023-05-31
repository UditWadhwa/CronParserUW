package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidStepRangeException;
import org.uw.parser.exception.NumericInvalidRangeException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseUtil;

public class MinuteHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int minuteFromValue, minuteToValue;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        minuteFromValue = BaseUtil.convertToInt(termSplit[0], term);
        if(hasIncrement)
            minuteToValue = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
        else
            minuteToValue = BaseUtil.convertToInt(termSplit[1], term);
        if(hasIncrement && (incrementBy > 59 || incrementBy < 0)){
            throw new InvalidStepRangeException(termStr, 0, 59, term);
        }

        if(minuteFromValue < 0 || minuteFromValue > 59 || minuteToValue < 0 || minuteToValue > 59)
            throw new NumericOutOfRangeException(minuteFromValue, minuteToValue, 0, 59, term);
        if(minuteFromValue > minuteToValue)
            throw new NumericInvalidRangeException(minuteFromValue, minuteToValue, term);
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy = 1;

        for(int i = minuteFromValue; i<= minuteToValue; i+=incrementBy){
            builder.append(i).append(" ");
        }
        return builder.toString().trim();
    }
}
