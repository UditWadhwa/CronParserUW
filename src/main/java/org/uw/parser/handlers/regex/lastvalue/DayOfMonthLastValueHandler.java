package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

public class DayOfMonthLastValueHandler extends BaseLastValueHandler implements LastValueHandler {

    private int val1;
    private boolean noPrefix;


    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        int in = termStr.indexOf('L');
        if(in == 0) {
            noPrefix = true;
            return;
        }

        val1 = BaseUtil.convertToInt(termStr.substring(0, in), term);

        if(val1 <= 0 || val1 > 31)
            throw new Exception(ErrorMessages.INVALID_OPERANDS + " Term- " + term.toString());
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
