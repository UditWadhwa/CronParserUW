package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class IncorrectMonthInputException extends Exception{
    public IncorrectMonthInputException(String termStr, Term term){
        super(String.format(ErrorMessages.INCORRECT_DAY_TERMS, termStr, term));
    }
}
