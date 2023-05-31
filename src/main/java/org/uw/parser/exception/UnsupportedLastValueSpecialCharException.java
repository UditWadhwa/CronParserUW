package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class UnsupportedLastValueSpecialCharException extends Exception{
    public UnsupportedLastValueSpecialCharException(String termStr, Term term){
        super(String.format(ErrorMessages.UNSUPPORTED_CHAR_WITH_PREFIX, termStr, term));
    }
}
