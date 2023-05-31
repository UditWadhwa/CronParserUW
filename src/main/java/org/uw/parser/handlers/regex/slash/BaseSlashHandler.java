package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidSlashTermException;

import java.util.regex.Pattern;

public class BaseSlashHandler {

    protected boolean hasTextData;

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("[0-9]+/[0-9]+", termStr) && !Pattern.matches("[A-Z]{3}/[0-9]+", termStr)){
            throw new InvalidSlashTermException(termStr, term);
        }
        if(Pattern.matches("[A-Z]{3}/[0-9]+", termStr))
            hasTextData = true;
    }

}
