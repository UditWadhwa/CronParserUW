package org.uw.parser.handlers.regex.slash;

import org.uw.parser.data.Term;

public interface SlashHandler {
    String process(String termStr, Term term) throws Exception;
}
