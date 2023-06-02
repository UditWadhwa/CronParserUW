package org.uw.parser.data;

public class Expression {

    private String minuteTerm;
    private String hourTerm;
    private String dayOfWeekTerm;
    private String dayOfMonthTerm;
    private String commandTerm;
    private String monthTerm;

    public void setCommandTerm(String commandTerm) {
        this.commandTerm = commandTerm;
    }

    private Expression(ExpressionBuilder builder){
        this.commandTerm = builder.commandTerm;
        this.dayOfMonthTerm = builder.dayOfMonthTerm;
        this.dayOfWeekTerm = builder.dayOfWeekTerm;
        this.minuteTerm = builder.minuteTerm;
        this.hourTerm = builder.hourTerm;
        this.monthTerm = builder.monthTerm;
    }

    public String getEnumTerm(Term term){
        switch (term){
            case Command -> {
                return commandTerm;
            }
            case Minute -> {
                return minuteTerm;
            }
            case Hour -> {
                return hourTerm;
            }
            case DayOfWeek -> {
                return dayOfWeekTerm;
            }
            case DayOfMonth -> {
                return dayOfMonthTerm;
            }
            case Month -> {
                return monthTerm;
            }
        }

        return null;

    }

    public String getMinuteTerm() {
        return minuteTerm;
    }

    public String getHourTerm() {
        return hourTerm;
    }

    public String getDayOfWeekTerm() {
        return dayOfWeekTerm;
    }

    public String getDayOfMonthTerm() {
        return dayOfMonthTerm;
    }

    public String getCommandTerm() {
        return commandTerm;
    }

    public String getMonthTerm() {
        return monthTerm;
    }

    public static class ExpressionBuilder{

        private String minuteTerm;
        private String hourTerm;
        private String dayOfWeekTerm;
        private String dayOfMonthTerm;
        private String commandTerm;
        private String monthTerm;

        public ExpressionBuilder setMinute(String minute){
            this.minuteTerm = minute;
            return this;
        }

        public ExpressionBuilder setHourTerm(String hourTerm) {
            this.hourTerm = hourTerm;
            return this;
        }

        public ExpressionBuilder setDayOfWeekTerm(String dayOfWeekTerm) {
            this.dayOfWeekTerm = dayOfWeekTerm;
            return this;
        }

        public ExpressionBuilder setDayOfMonthTerm(String dayOfMonthTerm) {
            this.dayOfMonthTerm = dayOfMonthTerm;
            return this;
        }

        public ExpressionBuilder setCommandTerm(String commandTerm) {
            this.commandTerm = commandTerm;
            return this;
        }

        public ExpressionBuilder setMonthTerm(String monthTerm) {
            this.monthTerm = monthTerm;
            return this;
        }

        public Expression build(){
            return new Expression(this);
        }
    }
}
