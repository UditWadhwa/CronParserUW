package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidLastValueTermException extends Exception{
    public InvalidLastValueTermException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_LAST_VALUE_EXPR, termStr, term));
    }
}
