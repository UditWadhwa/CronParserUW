package org.uw.parser;

public class ErrorMessages {

    public static final String INVALID_CHAR_EXPR = "Invalid expression. Please check the cron expression. [%s] character is invalid in term-[%s].";
    public static final String INVALID_CHAR_EXPR_LENGTH = "Invalid expression. Please check the length of cron expression term-[%s]. Not more than [%d] chars are allowed.";
    public static final String INVALID_EXPR = "Invalid expression. Please check the cron expression" +
            " syntax [min hour day_of_month month day_of_week command].";

    public static final String INCORRECT_COMMA_TERM = "Invalid comma expression [%s]. Term - [%s]";
    public static final String INCORRECT_ASTERISK_TERM = "Invalid asterisk expression [%s]. Term - [%s]";
    public static final String INCORRECT_HYPHEN_TERM = "Invalid hyphen expression [%s]. Term - [%s]";
    public static final String INCORRECT_SLASH_TERM = "Invalid slash expression [%s]. Term - [%s]";
    public static final String BLANK_COMMAND = "Invalid command in the cron expression.";
    public static final String INVALID_NUMERIC = "Invalid numeric term-[%d]. Valid Range is [%d-%d]. Term- [%s]";
    public static final String UNSUPPORTED_CHAR = "[%s] special character is not supported at present for term-[%s].";
    public static final String UNSUPPORTED_CHAR_WITH_PREFIX = "[%s] special character is not supported with numeric prefix at present for term-[%s]." +
            "You can use 'L' for the term-[Month]";

    public static final String INCORRECT_DAY_TERMS = "Invalid cron expression. Invalid value [%s] in field [%s].";

    public static final String OUT_OF_RANGE_NUMERIC = "Out of range numeric value. Value [%s] must be within [%d-%d]. Term-[%s]";

    public static final String INCORRECT_HYPHEN_RANGE = "Invalid range [%d-%d] for field [%s]. From or to value is out of allowed min/max values. Allowed values are between [%d-%d].";
    public static final String INCORRECT_LAST_VALUE_EXPR = "Invalid last value expression.";
    public static final String INVALID_PATTERN_FOR_TERM = "Invalid special character for this term.";
    public static final String INVALID_STEP_RANGE_FOR_FIELD = "Invalid step range for field-[%s]. It must be between [%d-%d]. Term-[%s] ";
    public static final String INCORRECT_HYPHEN_RANGE_FROM = "Invalid range. From value [%d] must be less than to value [%d]. Term-[%s]";
}
