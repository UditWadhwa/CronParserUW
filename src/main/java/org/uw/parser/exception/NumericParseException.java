package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class NumericParseException extends Exception{
    public NumericParseException(String termStr, Term term){
        super(String.format(ErrorMessages.INVALID_NUMERIC, termStr, term));
    }
}
