package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class NumericInvalidRangeException extends Exception{
    public NumericInvalidRangeException( int from, int to, Term term){
        super(String.format(ErrorMessages.INCORRECT_HYPHEN_RANGE_FROM, from, to, term));
    }

}
