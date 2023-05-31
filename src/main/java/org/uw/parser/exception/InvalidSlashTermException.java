package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidSlashTermException extends Exception{
    public InvalidSlashTermException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_SLASH_TERM, termStr, term));
    }
}
