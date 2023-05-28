package org.uw.parser;

import org.uw.parser.data.Expression;
import org.uw.parser.data.Term;
import org.uw.parser.handlers.TermHandler;
import org.uw.parser.handlers.TermHandlersFactory;

public class CommandProcessor {

    private TermHandlersFactory termHandlersFactory;

    public CommandProcessor(){
        termHandlersFactory = TermHandlersFactory.getInstance();
    }

    public String process(String exprString){
        Expression expr = getExpression(exprString);

        StringBuilder builder = new StringBuilder();

        for(Term term : Term.values()){
            TermHandler termHandler = termHandlersFactory.getTermHandler(term);
            termHandler.preProcess();
            builder.append(termHandler.process(expr.getEnumTerm(term)));
            builder.append("\n");
        }


        return builder.toString();
    }

    private Expression getExpression(String exprString){
        String[] terms = exprString.split("\\ ");
        Expression.ExpressionBuilder expressionBuilder = new Expression.ExpressionBuilder();
        expressionBuilder.setMinute(terms[0]).setHourTerm(terms[1])
                .setDayOfWeekTerm(terms[2]).setDayOfMonthTerm(terms[3]).setMonthTerm(terms[4])
                .setCommandTerm(terms[5]);

        return expressionBuilder.build();
    }

}
