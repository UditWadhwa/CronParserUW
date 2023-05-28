package org.uw.parser.handlers.regex.comma;

import org.uw.parser.data.Term;

public interface CommaHandler {
    String process(String termStr, Term term) throws Exception;
}
