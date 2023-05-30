package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.util.BaseUtil;

public class HourHyphenHandler extends BaseHyphenHandler implements HyphenHandler {
    private int val1, val2;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        val1 = BaseUtil.convertToInt(termSplit[0], term);
        if(hasIncrement)
            val2 = BaseUtil.convertToInt(termSplit[1].substring(0, termSplit[1].indexOf('/')), term);
        else
            val2 = BaseUtil.convertToInt(termSplit[1], term);
        if(val1 < 0 || val1 > 23 || val2 < 0 || val2 > 23)
            throw new Exception(String.format(ErrorMessages.INVALID_OPERANDS_HYPHEN, val1, val2, term, 0, 23));
        if(val1 > val2)
            throw new Exception(String.format(ErrorMessages.INCORRECT_HYPHEN_RANGE_FROM, val1, val2, term));

        if(hasIncrement && (incrementBy > 23 || incrementBy < 0)){
            throw new Exception(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD +" 23" + ". Range-"+ incrementBy
                    + ". Term-"+ term);
        }

    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();
        if(incrementBy == 0)
            incrementBy =1;

        for(int i=val1; i<=val2; i+=incrementBy){
            builder.append(i).append(" ");
        }
        return builder.toString().trim();
    }
}
