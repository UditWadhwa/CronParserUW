package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidCommaTermException extends Exception{
    public InvalidCommaTermException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_COMMA_TERM, termStr, term));
    }
}
