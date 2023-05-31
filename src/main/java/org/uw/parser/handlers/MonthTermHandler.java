package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.exception.*;
import org.uw.parser.util.BaseConstants;
import org.uw.parser.util.BaseUtil;

import java.util.ArrayList;
import java.util.List;

public class MonthTermHandler extends BaseTermHandler implements TermHandler{

    public MonthTermHandler() {
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
        StringBuilder builder = new StringBuilder(String.format("%13s","month "));

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.Month).process(term, Term.Month)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.Month).process(term, Term.Month)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Month).process(term, Term.Month)).toString();
            case Comma: return builder.append(this.commaHandlerFactory.getCommaHandler(Term.Month).process(term, Term.Month)).toString();
        };

        throw new UnsupportedSpecialCharException(specialChar.toString(), Term.Month);
    }

    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new InvalidTermCharacterException(p.toString(), Term.Month);
        if(p != CronSpecialChar.Base)
            return true;

        if(BaseConstants.MONTH_TERMS.contains(term))
            return true;

        int val =1;
        try {
            val = BaseUtil.convertToInt(term, Term.DayOfMonth);
        }
        catch (Exception e){
            throw new IncorrectMonthInputException(term, Term.DayOfMonth);
        }

        if(p == CronSpecialChar.Base && val <= 0 || val > 12)
            throw new NumericOutOfRangeException(term, 1, 12, Term.Month);

        return true;
    }

}
