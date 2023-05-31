package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidTermCharacterException extends Exception{
    public InvalidTermCharacterException(String termStr, Term term){
        super(String.format(ErrorMessages.INVALID_CHAR_EXPR, termStr, term));
    }

    public InvalidTermCharacterException(String termStr, String term){
        super(String.format(ErrorMessages.INVALID_CHAR_EXPR, termStr, term));
    }
}
