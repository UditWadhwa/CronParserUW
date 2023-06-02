package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.exception.InvalidTermCharacterException;
import org.uw.parser.exception.NumericOutOfRangeException;
import org.uw.parser.exception.UnsupportedSpecialCharException;
import org.uw.parser.util.BaseUtil;

import java.util.*;

public class MinuteTermHandler extends BaseTermHandler implements TermHandler{


    public MinuteTermHandler() {
        super();
    }

    private List<CronSpecialChar> blackListed = new ArrayList<>(List.of(CronSpecialChar.QuestionMark, CronSpecialChar.Hash,
            CronSpecialChar.LastValue, CronSpecialChar.Weekday));


    @Override
    public String process(String term, Expression expr) throws Exception{
        // 1-10
        // 20-30/2
        // 45

        super.process(term);
        CronSpecialChar pattern = CronSpecialChar.Base;
        StringBuilder outputBuilder = new StringBuilder(String.format("%13s","minute "));

        for(int j = 0; j < termTokens.size(); j++) {
            pattern = classify(termTokens.get(j));
            validate(pattern, termTokens.get(j));
            outputBuilder.append(generate(termTokens.get(j), pattern)).append(" ");
        }

        return processOutput(outputBuilder.toString());
    }


    private String processOutput(String output){
        StringBuilder finalBuilder = new StringBuilder();

        Set<String> uniqueSet = new HashSet<>();
        String[] tokenString = output.split(" ");
        for(int j=0; j < tokenString.length; j++){
            uniqueSet.add(tokenString[j]);
        }

        Iterator<String> itr = uniqueSet.iterator();
        while(itr.hasNext()){
            finalBuilder.append(itr.next()).append(" ");
        }
        return finalBuilder.toString().trim();
    }

    @Override
    protected String generate(String term, CronSpecialChar specialChar) throws Exception{
        StringBuilder builder = new StringBuilder();

        if(specialChar == CronSpecialChar.Base)
            return builder.append(super.generate(term, CronSpecialChar.Base)).toString();

        switch (specialChar){
            case Slash : return builder.append(this.slashHandlerFactory.getSlashHandler(Term.Minute).process(term, Term.Minute)).toString();
            case Hyphen : return builder.append(this.hyphenHandlerFactory.getHyphenHandler(Term.Minute).process(term, Term.Minute)).toString();
            case Asterisk: return builder.append(this.asteriskHandlerFactory.getAsteriskHandler(Term.Minute).process(term, Term.Minute)).toString();
            case Comma: return builder.append(this.commaHandlerFactory.getCommaHandler(Term.Minute).process(term, Term.Minute)).toString();
        };

        throw new UnsupportedSpecialCharException(specialChar.toString(), Term.Minute);
    }


    private boolean validate(CronSpecialChar p, String term) throws Exception {
        if(blackListed.contains(p))
            throw new InvalidTermCharacterException(p.toString(), Term.Minute);
        if(p != CronSpecialChar.Base)
            return true;

        int val = BaseUtil.convertToInt(term, Term.Minute);

        if(p == CronSpecialChar.Base && val < 0 || val > 59)
            throw new NumericOutOfRangeException(term, 0, 59, Term.Minute);

        return true;
    }




}
