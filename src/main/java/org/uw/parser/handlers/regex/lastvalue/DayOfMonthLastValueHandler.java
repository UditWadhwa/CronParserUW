package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseUtil;

public class DayOfMonthLastValueHandler extends BaseLastValueHandler implements LastValueHandler {

    private int lastValuePrefix;
    private boolean noPrefix;


    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        int in = termStr.indexOf('L');
        if(in == 0) {
            noPrefix = true;
            return;
        }

        lastValuePrefix = BaseUtil.convertToInt(termStr.substring(0, in), term);

        if(lastValuePrefix <= 0 || lastValuePrefix > 31)
            throw new NumericOutOfRangeException(lastValuePrefix, 1, 31, term);
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();

        if(noPrefix){
            builder.append("31");
        }


        return builder.toString().trim();
    }

}
