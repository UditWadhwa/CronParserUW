# CronParserUW

A simple Cron Parser, which checks for 5 terms minute, hour, dayOfMonth, month, dayOfWeek, and one extra command term.
Post downloading the code you could run the main method in CommandListener.java 

The method expects the cron expression in following sample formats, and post each input would return the output or the exception message.

Following Cron Special characters are supported so far: 
1. Asterisk *
2. Comma ,
3. Slash /
4. Hyphen - 

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
