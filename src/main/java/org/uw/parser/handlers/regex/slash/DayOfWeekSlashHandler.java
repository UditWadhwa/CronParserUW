package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;
import org.uw.parser.exception.IncorrectDayInputException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfWeekSlashHandler extends BaseSlashHandler implements SlashHandler {

    private int beginValue, stepRangeValue;
    private String beginTextValue;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("/");
        if(hasTextData) {
            beginTextValue = termSplit[0];
            if(!BaseConstants.DAY_OF_WEEK_TERMS.contains(beginTextValue))
                throw new IncorrectDayInputException(termStr, term);
        }
        else {
            beginValue = BaseUtil.convertToInt(termSplit[0], term);
            if(beginValue < 0 ||  beginValue > 7 )
                throw new NumericOutOfRangeException(beginValue, stepRangeValue, 0, 7, term);
        }
        stepRangeValue = BaseUtil.convertToInt(termSplit[1], term);
        if(stepRangeValue < 0 || stepRangeValue > 7)
            throw new NumericOutOfRangeException(beginValue, stepRangeValue, 0, 7, term);
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);

        StringBuilder builder = new StringBuilder();

        int i;
        if(stepRangeValue == 0)
            stepRangeValue = 1;

        if(hasTextData){
            int j=0;
            for(i = BaseConstants.DAY_OF_WEEK_TERMS.indexOf(beginTextValue);
                i < BaseConstants.DAY_OF_WEEK_TERMS.size();i++){
                if(j % stepRangeValue == 0){
                    builder.append(BaseConstants.DAY_OF_WEEK_TERMS.get(i)).append(" ");
                }
                j++;
            }
        }
        else {
            for (i = beginValue; i <= 7; i += stepRangeValue) {
                builder.append(i).append(" ");
            }
        }

        return builder.toString().trim();
    }
}
