package org.uw.parser;

import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.handlers.TermHandler;
import org.uw.parser.handlers.TermHandlersFactory;

public class CommandProcessor {

    private TermHandlersFactory termHandlersFactory;
    private Expression expr;

    public Expression getExpr() {
        return expr;
    }

    public CommandProcessor(){
        termHandlersFactory = TermHandlersFactory.getInstance();
    }

    public String process(String exprString) throws Exception{
        expr = getExpression(exprString);

        StringBuilder builder = new StringBuilder();

        for(Term term : Term.values()){
            TermHandler termHandler = termHandlersFactory.getTermHandler(term);

            builder.append(termHandler.process(expr.getEnumTerm(term), expr));
            builder.append("\n");
        }


        return builder.toString();
    }

    private Expression getExpression(String exprString){
        String[] terms = exprString.split("\\ ");
        Expression.ExpressionBuilder expressionBuilder = new Expression.ExpressionBuilder();
        expressionBuilder.setMinute(terms[0]).setHourTerm(terms[1])
                .setDayOfMonthTerm(terms[2]).setMonthTerm(terms[3]).setDayOfWeekTerm(terms[4])
                .setCommandTerm(terms[5]);

        return expressionBuilder.build();
    }

}
