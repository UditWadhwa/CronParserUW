package org.uw.parser.handlers.regex.comma;

import java.util.HashSet;
import java.util.Set;

public class DayOfWeekCommaHandler extends  BaseCommaHandler implements CommaHandler {


    private Set<String> days = new HashSet<>();
    public DayOfWeekCommaHandler(){
        days.add("MON"); days.add("SUN");
        days.add("TUE"); days.add("WED");
        days.add("THUR"); days.add("FRI");
        days.add("SAT");
    }

    @Override
    public String process(String term) throws Exception {
        String[] termSplit = term.split("\\,");
        StringBuilder builder = new StringBuilder();
        boolean numericTerms = true;

        for(int i=0; i< termSplit.length;i++){
            Integer temp = isNumeric(termSplit[i]);
            if(!numericTerms && temp != null)
                throw new Exception();

            if(temp == null && !isValid(termSplit[i]))
            {
                numericTerms = false;

            }
            if(!isValid(termSplit[i]))
                throw new Exception();
            builder.append(termSplit[i]).append(" ");
        }

        return builder.toString().trim();

    }

    private Integer isNumeric(String term){
        Integer val = null;
        try{
            val = Integer.parseInt(term);
        }
        catch (Exception e){

        }

        return val;
    }

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
        if(val == null || val < 0 || val > 7)
            return false;

        return true;
    }

}
