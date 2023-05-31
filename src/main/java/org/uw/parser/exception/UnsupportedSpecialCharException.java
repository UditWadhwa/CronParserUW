package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class UnsupportedSpecialCharException extends Exception{
    public UnsupportedSpecialCharException(String termStr, Term term){
        super(String.format(ErrorMessages.UNSUPPORTED_CHAR, termStr, term));
    }
}
