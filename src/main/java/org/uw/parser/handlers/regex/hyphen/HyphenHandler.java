package org.uw.parser.handlers.regex.hyphen;

import org.uw.parser.data.Term;

public interface HyphenHandler {
    String process(String termStr, Term term) throws Exception;
}
