package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidHyphenTermException;
import org.uw.parser.util.BaseUtil;

import java.util.regex.Pattern;

public class BaseHyphenHandler {

    protected boolean hasIncrement;
    protected int incrementBy;
    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("[0-9]{1,}-[0-9]{1,}", termStr) &&
                !Pattern.matches("[A-Z]{3}-[A-Z]{3}", termStr) &&
                !Pattern.matches("[0-9]{1,}-[0-9]{1,}/[0-9]+", termStr) &&
                !Pattern.matches("[A-Z]{3}-[A-Z]{3}/[0-9]+", termStr)) {
            throw new InvalidHyphenTermException(termStr, term);
        }

            if(termStr.contains("/")){
                hasIncrement = true;
                String temp = termStr.substring(termStr.indexOf("/")+1);
                incrementBy = BaseUtil.convertToInt(temp, Term.Hour);
            }
    }
}
