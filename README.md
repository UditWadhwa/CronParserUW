# CronParserUW

A simple Cron Parser, which checks for 5 terms minute, hour, dayOfMonth, month, dayOfWeek, and one extra command term.
Post downloading the code you could run the main method in CommandListener.java 

The method expects the cron expression in following sample formats, and post each input would return the output or the exception message.

Following Cron Special characters are supported so far: 
1. Asterisk *
2. Comma ,
3. Slash /
4. Hyphen - 
5. LastValue L 
     (*complete support for Day_of_week term. For Day_of_month term without numeric prefix support is there.*)

Sample valid inputs:
```

1. 4-34/3 2-17/3 5-25/5 JAN-JUL/2 MON-FRI/2 /abcdc
2. * * * * * /abcd
3. */10 * * * * /abd
4. 4-58 * 20-30 5,11,10 WED-SAT /abcd

```
Refer [link](https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm) for more sample expressions.

Sample output for the first case:
```

      minute 4 7 10 13 16 19 22 25 28 31 34
        hour 2 5 8 11 14 17
day of month 5 10 15 20 25
       month JAN MAR MAY JUL
 day of week MON WED FRI
     command /abcdc

```

To exit from the program, simply type ***exit*** on the command line.

### Running the application
The application is built as a simple main method execution. [CommandListener.java](https://github.com/UditWadhwa/CronParserUW/blob/main/src/main/java/org/uw/parser/CommandListener.java) has the main method.

The main method continuosly reads the inputs from System.in and with each expression entered followed by newline, the processing begins. 
Post validation and processing the desired output (or error message incase of sad path) is available on the console. 
The next set of input expressions can then be given on the console again followed by the newline character.

For exiting the application, simply type ***exit*** on the command line.

### Testcases
Apart from unit testcases. There is a [Test Class](https://github.com/UditWadhwa/CronParserUW/blob/main/src/test/java/org/uw/parser/CommandListenerTest.java) which runs end-to-end tests for valid cron expressions and compares with expected outputs as stored in [file](https://github.com/UditWadhwa/CronParserUW/blob/main/src/test/resources/TestcaseOutputFile).
End-to-End testcases are run as a single unit test. They iterate over different sample inputs (happy path) listed in the java test file above.

All the testcases can be run from command-line using Maven. They are the unit testcases covering different files.
```
mvn test
```

