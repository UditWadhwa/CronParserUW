package org.uw.parser;

import org.uw.parser.data.Expression;
import org.uw.parser.validators.BaseValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandListener {

    private static BaseValidator baseValidator;
    private static CommandProcessor processor;

    public CommandListener(){
        this.baseValidator = new BaseValidator();
        this.processor = new CommandProcessor();
    }

    public static void main1(String []argv){
        System.out.println(Pattern.matches("[A-Z]{3}-[A-Z]{3}", "1-FRI"));
        System.out.println(Pattern.matches("[0-7]-[0-7]", "1-7"));
        System.out.println(Pattern.matches("[0-9]+/[0-9]+", "A/7"));
        System.out.println(Pattern.matches("[0-9]*L$", "7L"));
        System.out.println(Pattern.matches("[0-9]*W$", "7W"));
        System.out.println(Pattern.matches("[0-9]*#[0-9]+$", "2#2"));
        System.out.println(Pattern.matches("\\*$", "*"));
        System.out.println(Pattern.matches("\\?$", "?"));
        System.out.println(Pattern.matches("([A-Z]{3},){1,}[A-Z]{3}$", "ACC,ABB,AAA,CCC"));

    }

    public static void main(String args[]){
        CommandListener obj = new CommandListener();
        while(true){
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            if(line.equalsIgnoreCase("exit"))
                break;
            else if(line.isBlank())
                continue;
            try {
                System.out.println(obj.processor.process(line));
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }


}
