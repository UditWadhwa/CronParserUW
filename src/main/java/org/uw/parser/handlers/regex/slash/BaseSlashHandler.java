package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;

import java.util.regex.Pattern;

public class BaseSlashHandler {

    public void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("[0-9]+/[0-9]+", termStr)){
            throw new Exception("Invalid Expression for " + term.toString());
        }
    }

}
