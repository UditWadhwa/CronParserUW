package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

import java.util.regex.Pattern;

public class BaseAsteriskHandler {

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("\\*$", termStr))
            throw new Exception("Invalid asterisk pattern. Term-"+ term.toString());
    }
}
