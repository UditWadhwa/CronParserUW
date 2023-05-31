package org.uw.parser.handlers;

import org.uw.parser.ErrorMessages;
import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidTermCharacterException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.util.BaseUtil;

import java.util.ArrayList;
import java.util.List;

public class HourTermHandler extends BaseTermHandler implements TermHandler{

    public HourTermHandler() {
        super();
    }

    private List<CronSpecialChar> blackListed = new ArrayList<>(List.of(CronSpecialChar.QuestionMark, CronSpecialChar.Hash,
            CronSpecialChar.LastValue, CronSpecialChar.Weekday));


    @Override
    public String process(String term, Expression expr) throws Exception{

        CronSpecialChar pattern = classify(term);
        validate(pattern, term);

        return generate(term, pattern);
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        StringBuilder builder = new StringBuilder(String.format("%13s","hour "));

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.Hour).process(term, Term.Hour)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.Hour).process(term, Term.Hour)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Hour).process(term, Term.Hour)).toString();
            case Comma: return builder.append(this.commaHandlerFactory.getCommaHandler(Term.Hour).process(term, Term.Hour)).toString();
        };

        return null;
    }


    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new InvalidTermCharacterException(p.toString(), Term.Hour);
        if(p != CronSpecialChar.Base)
            return true;

        int val = BaseUtil.convertToInt(term, Term.Hour);

        if(p == CronSpecialChar.Base && val < 0 || val > 23)
            throw new NumericOutOfRangeException(term, 0, 23, Term.Hour);

        return true;
    }



}
