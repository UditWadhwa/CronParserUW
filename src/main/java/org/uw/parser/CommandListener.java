package org.uw.parser;



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
        /*
        4-34/3 2-17/3 5-25/5 JAN-JUL/2 MON-FRI/2 /abcdc
      minute 4 7 10 13 16 19 22 25 28 31 34
        hour 2 5 8 11 14 17
day of month 5 10 15 20 25
       month JAN MAR MAY JUL
 day of week MON WED FRI
     command /abcdc

         */
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
                baseValidator.validate(line);
                System.out.println(obj.processor.process(line));
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }


}
