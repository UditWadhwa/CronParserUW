package org.uw.parser.handlers.regex.hyphen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class HourHyphenHandlerTest {

    private HourHyphenHandler HyphenHandler;
    private String validExpr = "0-0";
    private String validExpr1 = "5-10";
    private String expectedOp1 = "5 6 7 8 9 10";
    private String validExpr2 = "5-23/3";
    private String expectedOp2 = "5 8 11 14 17 20 23";

    @Before
    public void setup(){
        HyphenHandler = new HourHyphenHandler();
    }

    @Test
    public void testWithValidZeroExpression(){
        try {
            HyphenHandler.process(validExpr, Mockito.any());
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr);
        }
    }

    @Test
    public void testWithValidHyphenExpression(){
        try {
            String op = HyphenHandler.process(validExpr1, Mockito.any());
            Assert.assertEquals(expectedOp1, op);
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr);
        }
    }

    @Test
    public void testWithValidHyphenExpressionWithIncr(){
        try {
            String op = HyphenHandler.process(validExpr2, Mockito.any());
            Assert.assertEquals(expectedOp2, op);
        }
        catch (Exception e)
        {
            Assert.fail("Exception not expected for Expr-"+ validExpr2);
        }
    }

    @Test(expected = Exception.class)
    public void testWithBoundsExceedExpression() throws Exception{
        HyphenHandler.process("2--0", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithOutOfMinuteBoundIncrementExpression() throws Exception{
        HyphenHandler.process("5-60", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithOutOfMinuteBoundStartExpression() throws Exception{
        HyphenHandler.process("502-6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithNegativeVals() throws Exception{
        HyphenHandler.process("-5-6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithNegativeVals1() throws Exception{
        HyphenHandler.process("5--6", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithTextVals() throws Exception{
        HyphenHandler.process("5-MIN", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectIncr() throws Exception{
        HyphenHandler.process("5-10/90", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectExpr2() throws Exception{
        HyphenHandler.process("-10/90", Mockito.any());
    }



    @Test(expected = Exception.class)
    public void testWithIncompleteExpr() throws Exception{
        HyphenHandler.process("5-", Mockito.any());
    }

}
