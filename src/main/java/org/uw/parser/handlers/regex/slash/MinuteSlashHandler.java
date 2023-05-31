package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseUtil;

public class MinuteSlashHandler extends BaseSlashHandler implements SlashHandler {

    private int beginValue, stepRangeValue;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("/");
        beginValue = BaseUtil.convertToInt(termSplit[0], term);
        stepRangeValue = BaseUtil.convertToInt(termSplit[1], term);
        if(beginValue < 0 || stepRangeValue < 0 || beginValue > 59 || stepRangeValue > 59)
            throw new NumericOutOfRangeException(beginValue, stepRangeValue, 0, 59, term);
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);

        StringBuilder builder = new StringBuilder();

        int i;
        if(stepRangeValue == 0)
            stepRangeValue =1;

        for(i= beginValue; i<= 59; i+= stepRangeValue){
            builder.append(i).append(" ");
        }

        return builder.toString().trim();
    }
}
