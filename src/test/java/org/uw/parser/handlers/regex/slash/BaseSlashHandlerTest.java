package org.uw.parser.handlers.regex.slash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BaseSlashHandlerTest {

    private BaseSlashHandler slashHandler;
    private String validSlash = "3/4";

    @Before
    public void setup(){
        slashHandler = new BaseSlashHandler();
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

}
