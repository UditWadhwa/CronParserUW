package org.uw.parser;


import org.uw.parser.handlers.TermHandlersFactory;

import java.util.Scanner;

public class CommandListener {

    private  BaseValidator baseValidator;
    private  CommandProcessor processor;
    private  TermHandlersFactory termHandlersFactory;

    public CommandListener(){
        this.baseValidator = new BaseValidator();
        this.termHandlersFactory = new TermHandlersFactory();
        this.processor = new CommandProcessor(termHandlersFactory);
    }

    public static void main(String args[]){
        CommandListener listener = new CommandListener();
        while(true){
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();

            if(inputLine.equalsIgnoreCase("exit"))
                break;
            else if(inputLine.isBlank())
                continue;
            System.out.println(listener.processInputExpressions(inputLine));
        }
    }

    public String processInputExpressions(String inputLine) {
        try {
            baseValidator.validate(inputLine);
            return processor.process(inputLine);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


}
