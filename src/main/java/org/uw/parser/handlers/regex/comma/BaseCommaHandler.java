package org.uw.parser.handlers.regex.comma;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidCommaTermException;

import java.util.regex.Pattern;

public class BaseCommaHandler {

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("([A-Z]{3},){1,}[A-Z]{3}$", termStr) &&
                !Pattern.matches("([0-9]{1,},){1,}[0-9]{1,}$", termStr))
            throw new InvalidCommaTermException(termStr, term);
    }

    public String process(String termStr, Term term) throws Exception {
        String[] termSplit = termStr.split("\\,");
        StringBuilder builder = new StringBuilder();
        for(int i=0; i< termSplit.length;i++){
            builder.append(termSplit[i]).append(" ");
        }

        return builder.toString().trim();
    }

}
