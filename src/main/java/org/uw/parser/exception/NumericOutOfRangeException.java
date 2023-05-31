package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class NumericOutOfRangeException extends Exception{
    public NumericOutOfRangeException(String termStr, int from, int to, Term term){
        super(String.format(ErrorMessages.OUT_OF_RANGE_NUMERIC, termStr, from, to, term));
    }

    public NumericOutOfRangeException( int givenfrom, int from, int to, Term term){
        super(String.format(ErrorMessages.INVALID_NUMERIC, givenfrom, from, to, term));
    }

    public NumericOutOfRangeException(int givenFrom, int givenTo, int from, int to, Term term){
        super(String.format(ErrorMessages.INCORRECT_HYPHEN_RANGE, givenFrom, givenTo, term, from, to));
    }
}
