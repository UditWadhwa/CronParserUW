package org.uw.parser.handlers;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.exception.BlankCommandException;
import org.uw.parser.exception.UnsupportedSpecialCharException;
import org.uw.parser.util.BaseUtil;

public class CommandHandler extends BaseTermHandler implements TermHandler{

    public CommandHandler(){
        super();
    }

    @Override
    public String process(String term, Expression expr) throws Exception{

        classify(term);
        CronSpecialChar pattern = CronSpecialChar.Base;
        validate(pattern, term);

        return generate(term, pattern);
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        StringBuilder builder = new StringBuilder(String.format("%13s","command "));

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        throw new UnsupportedSpecialCharException(specialChar.toString(), Term.Command);
    }


    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(term.isBlank())
            throw new BlankCommandException();
        return true;
    }
}
