package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.handlers.regex.asterisk.AsteriskHandlerFactory;
import org.uw.parser.handlers.regex.comma.CommaHandlerFactory;
import org.uw.parser.handlers.regex.hyphen.HyphenHandlerFactory;
import org.uw.parser.handlers.regex.lastvalue.LastValueHandlerFactory;
import org.uw.parser.handlers.regex.slash.SlashHandlerFactory;

public class BaseTermHandler {
    protected AsteriskHandlerFactory asteriskHandlerFactory;
    protected SlashHandlerFactory slashHandlerFactory;
    protected HyphenHandlerFactory hyphenHandlerFactory;
    protected CommaHandlerFactory commaHandlerFactory;
    protected LastValueHandlerFactory lastValueHandlerFactory;

    public BaseTermHandler(){
        this.asteriskHandlerFactory = AsteriskHandlerFactory.getInstance();
        this.slashHandlerFactory = SlashHandlerFactory.getInstance();
        this.hyphenHandlerFactory = HyphenHandlerFactory.getInstance();
        this.commaHandlerFactory = CommaHandlerFactory.getInstance();
        this.lastValueHandlerFactory = LastValueHandlerFactory.getInstance();
    }

    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        return term.trim();
    }

    protected CronSpecialChar classify(String term){
        if(term.contains("*"))
            return CronSpecialChar.Asterisk;
        if(term.contains(","))
            return CronSpecialChar.Comma;
        if(term.contains("-"))
            return CronSpecialChar.Hyphen;
        if(term.contains("/"))
            return CronSpecialChar.Slash;
        if(term.contains("#"))
            return CronSpecialChar.Hash;
        if(term.contains("?"))
            return CronSpecialChar.QuestionMark;
        if(term.contains("L"))
            return CronSpecialChar.LastValue;
        if(term.contains("W"))
            return CronSpecialChar.Weekday;

        return CronSpecialChar.Base;
    }

}
