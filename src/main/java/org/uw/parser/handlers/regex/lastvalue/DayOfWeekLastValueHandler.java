package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfWeekLastValueHandler extends BaseLastValueHandler implements LastValueHandler {

    private int lastValuePrefix;
    boolean noPrefix;
    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        int in = termStr.indexOf('L');
        if(in == 0) {
            noPrefix = true;
            return;
        }

        lastValuePrefix = BaseUtil.convertToInt(termStr.substring(0, in), term);
        if(lastValuePrefix < 0 || lastValuePrefix > 7)
            throw new NumericOutOfRangeException(lastValuePrefix, 0, 7, Term.DayOfWeek);
    }


    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(noPrefix){
            builder.append("SUN");
        }
        else {
            if(lastValuePrefix == 0)
                builder.append("SUN");
            else if(lastValuePrefix == 7)
                builder.append("SAT");
            else
                builder.append(BaseConstants.DAY_OF_WEEK_TERMS.get(lastValuePrefix -1));
        }

        return builder.toString().trim();
    }

}
