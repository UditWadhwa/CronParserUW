package org.uw.parser.handlers.regex.comma;

public class DayOfMonthCommaHandler extends BaseCommaHandler implements CommaHandler {

    @Override
    protected boolean isValid(String term) {
        if(term.isEmpty())
            return false;

        Integer val = null;
        try{
            val  = Integer.parseInt(term);
        }
        catch (Exception e){

        }
        if(val == null || val < 0 || val > 31)
            return false;

        return true;
    }

    @Override
    public String process(String term) throws Exception {
        return super.process(term);
    }
}
