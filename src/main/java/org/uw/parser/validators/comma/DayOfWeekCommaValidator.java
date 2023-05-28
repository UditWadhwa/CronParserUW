package org.uw.parser.validators.comma;

import org.uw.parser.handlers.regex.comma.DayOfWeekCommaHandler;

import java.util.HashSet;
import java.util.Set;

public class DayOfWeekCommaValidator {

    private Set<String> uniqueDays;
    private Set<Integer> uniqueNumericDays;

    public DayOfWeekCommaValidator(){
        uniqueDays = new HashSet<>();
        uniqueNumericDays = new HashSet<>();
    }

    public boolean isValid(String term) throws Exception{
        String[] termSplit = term.split("\\,");
        boolean isNumeric = false, isText = false;

        for(int i=0; i< termSplit.length;i++){
            if(termSplit[i].isEmpty())
                throw new Exception("");

            Integer val = null;
            String dayName = "";

            val = isNumeric(termSplit[i]);


        }


        return true;
    }

    private Integer isNumeric(String term){
        Integer val = null;
        try{
            val  = Integer.parseInt(term);
        }
        catch (Exception e){

        }
        return val;
    }

}
