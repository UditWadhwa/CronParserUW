package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Expression;


public interface TermHandler {
    String process(String term, Expression expr) throws Exception;
}
