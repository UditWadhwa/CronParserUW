package org.uw.parser.handlers.regex.lastvalue;

import org.uw.parser.data.Term;

public interface LastValueHandler {
    String process(String termStr, Term term) throws Exception;
}
