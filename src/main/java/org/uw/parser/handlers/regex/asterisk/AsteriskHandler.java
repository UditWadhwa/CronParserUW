package org.uw.parser.handlers.regex.asterisk;

import org.uw.parser.data.Term;

public interface AsteriskHandler {
    String process(String termStr, Term term) throws Exception;
}
