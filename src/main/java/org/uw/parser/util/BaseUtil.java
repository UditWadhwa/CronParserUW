package org.uw.parser.util;

import org.uw.parser.data.Term;

public class BaseUtil {

    public static int convertToInt(String termStr, Term term) throws Exception{
        Integer val = null;
        try{
            val = Integer.parseInt(termStr);
        }
        catch (Exception e){
            throw new Exception("Error while converting string to integer. Term-" + term.toString());
        }
        return (int) val;
    }

}
