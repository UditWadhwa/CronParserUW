package org.uw.parser;

public class ErrorMessages {

    public static final String INVALID_CHAR_EXPR = "Invalid expression. Please check the cron expression. [%s] character is invalid in term-[%s].";
    public static final String INVALID_CHAR_EXPR_LENGTH = "Invalid expression. Please check the length of cron expression term-[%s]. Not more than [%d] chars are allowed.";
    public static final String INVALID_EXPR = "Invalid expression. Please check the cron expression" +
            " syntax [min hour day_of_month month day_of_week command].";
    public static final String INCORRECT_ASTERISK_TERM = "Incorrect Asterisk Term";
    public static final String INCORRECT_COMMA_TERM = "Invalid comma expression.";
    public static final String INVALID_OPERANDS = "Invalid operands for the term";
    public static final String INVALID_OPERANDS_HYPHEN = "Invalid range [%s-%s] for field [%s]. From or to value is out of allowed" +
            " min/max values. Allowed values are between [%s-%s].";
    public static final String INCORRECT_DAY_OF_WEEK_TERMS = "Incorrect day of week operands for the term";
    public static final String INCORRECT_DAY_OF_WEEK_NUMERIC = "Incorrect day of week numeric.";
    public static final String INCORRECT_MONTH_NUMERIC = "Incorrect day of month numeric.";
    public static final String INCORRECT_MONTH_TEXTUAL = "Incorrect month text.";
    public static final String INCORRECT_HYPHEN_RANGE = "Invalid range [6-100] for field [minute]. From or to value is out of allowed min/max values. Allowed values are between [0-59].";
    public static final String INCORRECT_LAST_VALUE_EXPR = "Invalid last value expression.";
    public static final String INVALID_PATTERN_FOR_TERM = "Invalid special character for this term.";
    public static final String INVALID_STEP_RANGE_FOR_FIELD = "Invalid step range for field. It must be less than or equals to ";
    public static final String INCORRECT_HYPHEN_RANGE_FROM = "Invalid range. From value [%s] must be less than to value [%s]. Term-[%s]";
}
