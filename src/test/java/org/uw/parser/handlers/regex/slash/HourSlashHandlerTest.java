package org.uw.parser.handlers.regex.slash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HourSlashHandlerTest {

    private HourSlashHandler slashHandler;
    private String validExpr = "0/0";
    private String validExpr1 = "5/10";
    private String expectedOp1 = "5 15";

    @Before
    public void setup(){
        slashHandler = new HourSlashHandler();
    }

    @Test
    public void testWithValidZeroExpression(){
        try {
            slashHandler.process(validExpr, Mockito.any());
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr);
        }
    }

    @Test
    public void testWithValidIncrementExpression(){
        try {
            String op = slashHandler.process(validExpr1, Mockito.any());
            Assert.assertEquals(expectedOp1, op);
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr);
        }
    }

    @Test
    public void testWithValid0IncAnd1IncrExpression(){
        try {
            String op = slashHandler.process("0/0", Mockito.any());
            String op1 = slashHandler.process("0/1", Mockito.any());
            Assert.assertEquals(op1, op);
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr);
        }
    }

    @Test(expected = Exception.class)
    public void testWithOutOfMinuteBoundIncrementExpression() throws Exception{
            slashHandler.process("5/60", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithOutOfHourBoundStartExpression() throws Exception{
        slashHandler.process("502/6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithNegativeVals() throws Exception{
        slashHandler.process("-5/6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithNegativeVals1() throws Exception{
        slashHandler.process("5/-6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithTextVals() throws Exception{
        slashHandler.process("5/MIN", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncompleteExpr() throws Exception{
        slashHandler.process("5/", Mockito.any());
    }

}
