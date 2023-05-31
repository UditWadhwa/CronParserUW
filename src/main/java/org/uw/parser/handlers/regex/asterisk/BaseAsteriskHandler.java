package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidAsteriskTermException;
import org.uw.parser.util.BaseUtil;

import java.util.regex.Pattern;

public class BaseAsteriskHandler {

    protected boolean hasIncrement;
    protected int incrementBy;

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("\\*/[0-9]+", termStr) && !Pattern.matches("\\*$", termStr))
            throw new InvalidAsteriskTermException(termStr, term);

        if(termStr.contains("/")){
            hasIncrement = true;
            String temp = termStr.substring(termStr.indexOf("/")+1);
            incrementBy = BaseUtil.convertToInt(temp, Term.Hour);
        }
    }
}
