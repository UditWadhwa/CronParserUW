package org.uw.parser.util;

import org.uw.parser.data.Term;
import org.uw.parser.exception.NumericParseException;

public class BaseUtil {

    public static int convertToInt(String termStr, Term term) throws Exception{
        Integer val = null;
        try{
            val = Integer.parseInt(termStr);
        }
        catch (Exception e){
            throw new NumericParseException(termStr, term);
        }
        return  val;
    }

}
