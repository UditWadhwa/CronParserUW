package org.uw.parser.handlers.regex.asterisk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uw.parser.handlers.regex.slash.BaseSlashHandler;

public class BaseAsteriskHandlerTest {

    private BaseAsteriskHandler slashHandler;
    private String invalidSlash = "3/4";
    private String validSlash = "*/4";

    @Before
    public void setup(){
        slashHandler = new BaseAsteriskHandler();
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveExtraSlashInTerm() throws Exception{
        slashHandler.validate("1//3", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveIncorrectExpr() throws Exception{
        slashHandler.validate("1/3/", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveJustSlash() throws Exception{
        slashHandler.validate("/", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHavePrefixSlash() throws Exception{
        slashHandler.validate("/2", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveSuffixSlash() throws Exception{
        slashHandler.validate("2/", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveForwardSlash() throws Exception{
        slashHandler.validate("2\\3", Mockito.any());
    }

    @Test
    public void testWhenWeHaveAValidSlashExpression(){
        try {
            slashHandler.validate(validSlash, Mockito.any());
        }
        catch (Exception e){
            Assert.fail("No exception was expected from a valid " +
                    "expression. ErrorMessage thrown - "+ e.getMessage() + " Expr-" + validSlash);
        }
    }

    @Test(expected = Exception.class)
    public void testWhenWeHaveInValidSlashExpression() throws Exception{
        slashHandler.validate(invalidSlash, Mockito.any());
    }


}
