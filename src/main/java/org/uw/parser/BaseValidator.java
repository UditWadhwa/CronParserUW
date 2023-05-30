package org.uw.parser;

import java.util.Arrays;

public class BaseValidator {

    private static final char[] BLACKLISTED_CHARS = {'`', '!', '@', '$', '%', '^', '&', '(',')',
    '_', '=', '+', '"', ';', ':', '[', ']', '{', '}', '.','|', '~', '\n', '\t', '\r'};

    private static final int MAX_CHAR_LIMIT = 30;

    public void validate(String exprStr) throws Exception{
        String[] exprSplit = exprStr.split(" ");
        if(exprSplit.length != 6){
            throw new Exception(ErrorMessages.INVALID_EXPR);
        }

        for(String term : exprSplit){
            if(term.length() > MAX_CHAR_LIMIT)
                throw new Exception(String.format(ErrorMessages.INVALID_CHAR_EXPR_LENGTH, term, MAX_CHAR_LIMIT));
            if(term.trim().isEmpty())
                throw new Exception(ErrorMessages.INVALID_EXPR);
            for(char ch : BLACKLISTED_CHARS){
                if(term.indexOf(ch) != -1){
                    throw new Exception(String.format(ErrorMessages.INVALID_CHAR_EXPR, ch, term));
                }
            }
        }




    }

}
