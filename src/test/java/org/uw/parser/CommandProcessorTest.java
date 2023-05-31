package org.uw.parser;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.uw.parser.data.Expression;
import org.uw.parser.handlers.TermHandler;
import org.uw.parser.handlers.TermHandlersFactory;

public class CommandProcessorTest {

    private CommandProcessor obj;
    @Mock
    public TermHandlersFactory termHandlersFactory;

    @Mock
    public TermHandler baseTermHandler;

    private String dummyExpr = "* * * * * /abc";
    private Expression expr;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        obj = new CommandProcessor(termHandlersFactory);
    }

    @Test
    public void testThatTermHandlerProcessIsCalled() throws Exception{
        givenTermHandlerFactoryReturnsImpl();
        obj.process(dummyExpr);
        Mockito.verify(baseTermHandler, Mockito.times(6)).process(Mockito.any(), Mockito.any());
    }

    private void givenTermHandlerFactoryReturnsImpl(){
        Mockito.when(termHandlersFactory.getTermHandler(Mockito.any())).thenReturn(baseTermHandler);
    }

}
