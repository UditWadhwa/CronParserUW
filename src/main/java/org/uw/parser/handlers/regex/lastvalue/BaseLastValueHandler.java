package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

import java.util.regex.Pattern;

public class BaseLastValueHandler {

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("[0-9]*L$", termStr)){
            throw new Exception(ErrorMessages.INCORRECT_LAST_VALUE_EXPR + " Term-" + term.toString());
        }
    }
}
