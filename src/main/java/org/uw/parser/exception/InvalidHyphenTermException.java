package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidHyphenTermException extends Exception{
    public InvalidHyphenTermException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_HYPHEN_TERM, termStr, term));
    }
}
