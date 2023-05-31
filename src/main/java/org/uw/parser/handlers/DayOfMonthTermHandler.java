package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.exception.IncorrectDayInputException;
import org.uw.parser.exception.InvalidTermCharacterException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.exception.UnsupportedSpecialCharException;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

import java.util.ArrayList;
import java.util.List;

public class DayOfMonthTermHandler extends BaseTermHandler implements TermHandler{

    public DayOfMonthTermHandler() {
        super();
    }

    private List<CronSpecialChar> blackListed = new ArrayList<>();

    @Override
    public String process(String term, Expression expr) throws Exception{

        CronSpecialChar pattern = classify(term);
        validate(pattern, term);

        return generate(term, pattern);
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        StringBuilder builder = new StringBuilder(String.format("%13s","day of month "));

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.DayOfMonth).process(term, Term.DayOfMonth)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.DayOfMonth).process(term, Term.DayOfMonth)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.DayOfMonth).process(term, Term.DayOfMonth)).toString();
            case Comma: return builder.append(this.commaHandlerFactory.getCommaHandler(Term.DayOfMonth).process(term, Term.DayOfMonth)).toString();
            case LastValue: return builder.append(this.lastValueHandlerFactory.getLastValueHandler(Term.DayOfMonth).process(term, Term.DayOfMonth)).toString();
        };

        throw new UnsupportedSpecialCharException(specialChar.toString(), Term.DayOfMonth);
    }


    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new InvalidTermCharacterException(p.toString(), Term.DayOfMonth);
        if(p != CronSpecialChar.Base)
            return true;

        int val = BaseUtil.convertToInt(term, Term.DayOfMonth);

        if(p == CronSpecialChar.Base && val <= 0 || val > 31)
            throw new NumericOutOfRangeException(term, 1, 31, Term.DayOfMonth);

        return true;
    }
}
