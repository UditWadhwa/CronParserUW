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

### Running the application from command line
Run the following maven command from the root project directory
```
mvn package

```
This shall successfully create a jar in the project target directory and should have following **sample output**.
```
 --- maven-jar-plugin:2.4:jar (default-jar) @ CronParser ---
[INFO] Building jar: /Users/uditwadhwa/CronParser/target/CronParser-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-shade-plugin:3.2.4:shade (default) @ CronParser ---
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /Users/uditwadhwa/CronParser/target/CronParser-1.0-SNAPSHOT.jar with /Users/uditwadhwa/CronParser/target/CronParser-1.0-SNAPSHOT-shaded.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

```
Post this step you may refer the jar from target directory and run following command to begin the application
```
java -jar <targetDirectory>/CronParser-1.0-SNAPSHOT.jar

```
Once the application is up, you can begin typing the cron expression in command-line and ***press enter***. The application would process the expression and return the output. After that you can feed in the next input expression and wait for output. The application continuosly listens to the the next input and displays the output or error message. Sample seen below

```
* * * * * /abd
      minute 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59
        hour 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
day of month 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 2 25 26 27 28 29 30 31
       month 1 2 3 4 5 6 7 8 9 10 11 12
 day of week 1 2 3 4 5 6 7
     command /abd

* * /ss
Invalid expression. Please check the cron expression syntax [min hour day_of_month month day_of_week command].
*/10 */5 * * MON-FRI /asgh
      minute 0 10 20 30 40 50
        hour 0 5 10 15 20
day of month 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 2 25 26 27 28 29 30 31
       month 1 2 3 4 5 6 7 8 9 10 11 12
 day of week MON TUE WED THU FRI
     command /ass


```

To exit from the application type "***exit***" on the command line.


### Testcases
Apart from unit testcases. There is a [Test Class](https://github.com/UditWadhwa/CronParserUW/blob/main/src/test/java/org/uw/parser/CommandListenerTest.java) which runs end-to-end tests for valid cron expressions and compares with expected outputs as stored in [file](https://github.com/UditWadhwa/CronParserUW/blob/main/src/test/resources/TestcaseOutputFile).
End-to-End testcases are run as a single unit test. They iterate over different sample inputs (happy path) listed in the java test file above.

All the testcases can be run from command-line using Maven. They are the unit testcases covering different files.
```
mvn test
```

