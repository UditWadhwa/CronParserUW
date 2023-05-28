package org.uw.parser.validators.hyphen;

public class HyphenValidator {

    public boolean validate(String term){
        String[] termSplit = term.split("-");
        return true;
    }
}
