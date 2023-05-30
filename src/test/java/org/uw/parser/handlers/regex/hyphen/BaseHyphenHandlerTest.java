package org.uw.parser.handlers.regex.hyphen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class BaseHyphenHandlerTest {

    private BaseHyphenHandler HyphenHandler;
    private String validHyphen = "3-4";
    private String validHyphen1 = "3-40/5";

    @Before
    public void setup(){
        HyphenHandler = new BaseHyphenHandler();
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveExtraHyphenInTerm() throws Exception{
        HyphenHandler.validate("1--3", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveIncorrectExpr() throws Exception{
        HyphenHandler.validate("1-3-", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveJustHyphen() throws Exception{
        HyphenHandler.validate("-", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHavePrefixHyphen() throws Exception{
        HyphenHandler.validate("-2", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveSuffixHyphen() throws Exception{
        HyphenHandler.validate("2-", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveBothNumericTextOperands() throws Exception{
        HyphenHandler.validate("2-WED", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveIncorrectIncrement() throws Exception{
        HyphenHandler.validate("2-3/-4", Mockito.any());
    }

    @Test
    public void testWhenWeHaveAValidHyphenExpression(){
        try {
            HyphenHandler.validate(validHyphen, Mockito.any());
        }
        catch (Exception e){
            Assert.fail("No exception was expected from a valid " +
                    "expression. ErrorMessage thrown - "+ e.getMessage() + " Expr-" + validHyphen);
        }
    }

    @Test
    public void testWhenWeHaveAValidHyphenExpressionWithIncr(){
        try {
            HyphenHandler.validate(validHyphen1, Mockito.any());
        }
        catch (Exception e){
            Assert.fail("No exception was expected from a valid " +
                    "expression. ErrorMessage thrown - "+ e.getMessage() + " Expr-" + validHyphen1);
        }
    }

}
