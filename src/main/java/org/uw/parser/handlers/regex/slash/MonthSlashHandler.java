package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;
import org.uw.parser.util.BaseUtil;

public class MonthSlashHandler extends BaseSlashHandler implements SlashHandler {

    private int val1, val2;

    @Override
    public void validate(String termStr, Term term) throws Exception {
        super.validate(termStr, term);
        String[] termSplit = termStr.split("/");
        val1 = BaseUtil.convertToInt(termSplit[0], term);
        val2 = BaseUtil.convertToInt(termSplit[1], term);
        if(val1 <= 0 || val1 > 12 || val2 < 0 || val2 > 12)
            throw new Exception("Invalid operands. Term-" + term.toString());
    }

    @Override
    public String process(String termStr, Term term) throws Exception{
        validate(termStr, term);

        StringBuilder builder = new StringBuilder();

        int i;
        if(val2 == 0)
            val2 = 1;

        for( i=val1; i<= 12; i+=val2){
            builder.append(i).append(" ");
        }

        /*i %=12;
        for(; i < val1; i+= val2){
            builder.append(i).append(" ");
        }
        */
        return builder.toString().trim();
    }
}
