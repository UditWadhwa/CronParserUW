package org.uw.parser.handlers;

import org.uw.parser.ErrorMessages;
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

public class DayOfWeekTermHandler extends BaseTermHandler implements TermHandler{
    public DayOfWeekTermHandler() {
        super();
    }

    private List<CronSpecialChar> blackListed = new ArrayList<>(List.of(CronSpecialChar.Weekday));

    @Override
    public String process(String term, Expression expr) throws Exception{

        CronSpecialChar pattern = classify(term);
        validate(pattern, term);

        return generate(term, pattern);
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        StringBuilder builder = new StringBuilder(String.format("%13s", "day of week "));

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.DayOfWeek).process(term, Term.DayOfWeek)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.DayOfWeek).process(term, Term.DayOfWeek)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.DayOfWeek).process(term, Term.DayOfWeek)).toString();
            case Comma: return builder.append(this.commaHandlerFactory.getCommaHandler(Term.DayOfWeek).process(term, Term.DayOfWeek)).toString();
            case LastValue: return builder.append(this.lastValueHandlerFactory.getLastValueHandler(Term.DayOfWeek).process(term, Term.DayOfWeek)).toString();
        };

        throw new UnsupportedSpecialCharException(specialChar.toString(), Term.DayOfWeek);
    }


    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new InvalidTermCharacterException(p.toString(), Term.DayOfWeek);
        if(p != CronSpecialChar.Base)
            return true;

        if(BaseConstants.DAY_OF_WEEK_TERMS.contains(term))
            return true;

        int val =1;
        try {
            val = BaseUtil.convertToInt(term, Term.DayOfWeek);
        }
        catch (Exception e){
            throw new IncorrectDayInputException(term, Term.DayOfWeek);
        }

        if(p == CronSpecialChar.Base && val <= 0 || val > 7)
            throw new NumericOutOfRangeException(term, 0, 7, Term.DayOfWeek);

        return true;
    }
}
