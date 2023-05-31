package org.uw.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandListenerTest {

    private CommandListener systemUnderTest;
    private Map<Integer, List<String>> testcaseOutputMap = new HashMap();


    private String[] inputExpressions = {"4-49/7 4/10 5/20 FEB-OCT MON-THU /acd",
                                            "* * * * * /abd",
                                         "4-49 4/10 5/20 FEB-OCT 1-6 /acd",
                                        "4/12 4-20/5 * * SUN /acd",
                                        "4/12 4-20/5 5,30,11 * SUN /ad",
                                        "4-34/3 2-17/3 5-25/5 JAN-JUL/2 MON-FRI/2 /abcdc",
                                        "56 * * * * /ss",
                                        "4 * */10 * * /ss",
                                        "4-21/5 4/10 4/10 JAN-SEP TUE-SAT/2 /dhjd",
                                        "4 3 30 FEB/3 MON/4 /dd"
                                        };

    @Before
    public void setup() throws Exception{
        systemUnderTest = new CommandListener();
        initTCOutputMap();
    }



    private void initTCOutputMap() throws IOException {
        String stubFileName = "TestcaseOutputFile";

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(stubFileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        String line = reader.readLine();
        List<String> outputs = new ArrayList<>();
        int testcaseId = -1;
        while(line != null){
            if(!line.isEmpty() && (line.charAt(0) >= '0' && line.charAt(0) <= '9'))
            {
                if(testcaseId != -1){
                    testcaseOutputMap.put(testcaseId, outputs);
                    outputs = new ArrayList<>();
                }

                testcaseId = Integer.parseInt(line);

            }
            else{
                outputs.add(line);
            }
            line = reader.readLine();
        }

        if(testcaseId != -1)
            testcaseOutputMap.put(testcaseId, outputs);
    }

    @Test
    public void testValidInputExpressions() throws Exception{
        int i=1;
        for(String ex : inputExpressions) {
            String output = systemUnderTest.processInputExpressions(ex);
            //System.out.println(output);
            String[] temp = output.split("\n");
            int j = 0; List<String> ls = testcaseOutputMap.get(i);
            for (String t : temp) {
                Assert.assertEquals("Testcase- " + i, ls.get(j), t);
                j++;
            }
            i++;
        }
    }
}
