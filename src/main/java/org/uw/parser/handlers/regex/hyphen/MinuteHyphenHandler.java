package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;
import org.uw.parser.util.BaseUtil;

public class MinuteHyphenHandler extends BaseHyphenHandler implements HyphenHandler {

    private int val1, val2;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("-");
        val1 = BaseUtil.convertToInt(termSplit[0], term);
        val2 = BaseUtil.convertToInt(termSplit[1], term);
        if(val1 < 0 || val2 > 59)
            throw new Exception("Invalid operands. Term- " + term.toString());
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);
        StringBuilder builder = new StringBuilder();

        for(int i=val1; i<=val2; i++){
            builder.append(i).append(" ");
        }
        return builder.toString().trim();
    }
}
