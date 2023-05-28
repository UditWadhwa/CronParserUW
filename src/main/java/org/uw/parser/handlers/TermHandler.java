package org.uw.parser.handlers;

import org.uw.parser.data.CronSpecialChar;
import org.uw.parser.data.Pattern;

public interface TermHandler {
    String process(String term) throws Exception;
    boolean validate(CronSpecialChar p, String term) throws Exception;
}
