package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidAsteriskTermException extends Exception{
    public InvalidAsteriskTermException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_ASTERISK_TERM, termStr, term));
    }
}
