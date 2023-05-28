package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Term;
import org.uw.parser.util.BaseUtil;

import java.util.ArrayList;
import java.util.List;

public class MinuteTermHandler extends BaseTermHandler implements TermHandler{

    public MinuteTermHandler() {
        super();
    }

    private List<CronSpecialChar> blackListed = new ArrayList<>(List.of(CronSpecialChar.QuestionMark, CronSpecialChar.Hash,
            CronSpecialChar.LastValue, CronSpecialChar.Weekday));


    @Override
    public String process(String term) throws Exception{

        CronSpecialChar pattern = classify(term);
        validate(pattern, term);

        return generate(term, pattern);
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) {
        StringBuilder builder = new StringBuilder("minute \t");

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.Minute).process(term)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.Minute).process(term)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Minute).process()).toString();
        };

        return null;
    }

    @Override
    public boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new Exception();
        int val = BaseUtil.convertToInt(term, Term.Minute);

        if(p == CronSpecialChar.Base && val < 0 || val > 59)
            throw new Exception();

        return true;
    }




}
