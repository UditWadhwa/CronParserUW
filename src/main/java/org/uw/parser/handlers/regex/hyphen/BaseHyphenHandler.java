package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;

import java.util.regex.Pattern;

public class BaseHyphenHandler {

    protected void validate(String termStr, Term term) throws Exception{
        if(!Pattern.matches("[0-9]{1,}-[0-9]{1,}", termStr)){
            throw new Exception("Invalid range expression. Term-" + term.toString());
        }
    }
}
