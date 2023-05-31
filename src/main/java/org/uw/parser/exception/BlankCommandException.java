package org.uw.parser.exception;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.Term;

public class BlankCommandException extends Exception{
    public BlankCommandException(){
        super(ErrorMessages.BLANK_COMMAND);
    }
}
