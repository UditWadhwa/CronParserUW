package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class InvalidStepRangeException extends Exception{
    public InvalidStepRangeException(String termStr, int from, int to, Term term){
        super(String.format(ErrorMessages.INVALID_STEP_RANGE_FOR_FIELD, termStr, from, to, term));
    }


}
