package org.uw.parser.handlers.regex.comma;

import org.uw.parser.data.Term;
import org.uw.parser.util.BaseUtil;

public class HourCommaHandler extends  BaseCommaHandler implements CommaHandler {

    private StringBuilder builder;

    @Override
    protected void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        builder = new StringBuilder();
        String[] termSplit = termStr.split("\\,");

        for(int i=0; i< termSplit.length;i++){
            int val = BaseUtil.convertToInt(termSplit[i], term);
            if(val < 0 || val > 23)
                throw new Exception("Illegal operands. Term-" + term.toString());

            builder.append(val).append(" ");
        }
    }

    @Override
    public String process(String termStr, Term term) throws Exception {
        validate(termStr, term);
        return builder.toString().trim();
    }

}
