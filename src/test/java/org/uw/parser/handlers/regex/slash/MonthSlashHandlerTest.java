package org.uw.parser.handlers.regex.slash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MonthSlashHandlerTest {

    private MonthSlashHandler slashHandler;
    private String invalidExpr = "DEC/2";
    private String validExpr = "3/2";
    private String input1 = "3/3";
    private String expectedOutput1 = "3 6 9 12";

    private String input2 = "3/2";
    private String expectedOutput2 = "3 5 7 9 11";


    @Before
    public void setup(){
        slashHandler = new MonthSlashHandler();
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectDataInExpr() throws Exception{
        slashHandler.process(invalidExpr, Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectMonthInExpr() throws Exception{
        slashHandler.process("34/22", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectIncrementValueInExpr() throws Exception{
        slashHandler.process("3/220", Mockito.any());
    }

    @Test
    public void testWithIncorrectIncrementValueInExpr1() {
        try {
            slashHandler.process("3/0", Mockito.any());
        }
        catch (Exception e){
            Assert.fail("Increment value can be zero for slash expression. " +
                    "Exception should not be thrown. Expr- 3/0");
        }
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectStartMonthValueInExpr() throws Exception{
        slashHandler.process("3333/2", Mockito.any());
    }

    @Test(expected = Exception.class)
    public void testWithIncorrectStartMonthValueInExpr1() throws Exception{
        slashHandler.process("-3/2", Mockito.any());
    }

    @Test
    public void testWithCorrectDataInExpr(){
        try {
            slashHandler.process(validExpr, Mockito.any());
        }
        catch (Exception e){
            Assert.fail("No exception was expected with this expr." + e.getMessage() + " Expr - "+ validExpr);
        }
    }

    @Test
    public void testWithExpectedOutput1(){
        try {
            String op = slashHandler.process(input1, Mockito.any());
            Assert.assertEquals(expectedOutput1, op);
        }
        catch (Exception e){
            Assert.fail("No exception was expected with this expr." + e.getMessage() + " Expr - "+ validExpr);
        }
    }

    @Test
    public void testWithExpectedOutput2(){
        try {
            String op = slashHandler.process(input2, Mockito.any());
            Assert.assertEquals(expectedOutput2, op);
        }
        catch (Exception e){
            Assert.fail("No exception was expected with this expr." + e.getMessage() + " Expr - "+ validExpr);
        }
    }

}
