public class StringCalculatorTest {

    private final static String TEST_ONE = "NULL STRING";
    private final static String TEST_TWO = "EMPTY STRING";
    private final static String TEST_THREE = "VALID STRING";
    private final static String TEST_FOUR = "INVALID STRING";

    private final static String SUCCESS = " TEST was successful";
    private final static String FAIL = " TEST has failed";

    public static void main(String args[]){
        testValidInputs();
        testInvalidInputs();
    }

    /**
     * Here, if output matches for valid input then it is considered success
     */
    static void testValidInputs(){
        // null check
        if(StringCalculator.add(null) == 0) {logTest(TEST_ONE, SUCCESS);}
        else {logTest(TEST_ONE, FAIL);}

        // empty string check
        if(StringCalculator.add("") == 0) {logTest(TEST_TWO, SUCCESS);}
        else {logTest(TEST_TWO, FAIL);}

        // valid number check
        if(StringCalculator.add("11,222,3") == 236){logTest(TEST_THREE, SUCCESS);}
        else {logTest(TEST_THREE, FAIL);}

        // handle unknown amount of numbers
        int testSum=0;
        String testString="";
        for(int i=1; i<=100; i++){
            testString += i + ",";
            testSum += i;
        }
        testString = testString.substring(0, testString.length()-1);

        if(StringCalculator.add(testString) == testSum){logTest(TEST_THREE, SUCCESS);}
        else {logTest(TEST_THREE, FAIL);}
    }

    /**
     * Here, if output matches for invalid input, then it is considered success
     */
    static void testInvalidInputs(){
        // invalid number check
        // numbers bigger than 1000 must be ignored
        if(StringCalculator.add("11,2222,3") == 14){logTest(TEST_FOUR, SUCCESS);}
        else {logTest(TEST_FOUR, FAIL);}
    }

    static void logTest(String TEST, String STATE){
        System.out.println(TEST + STATE);
    }
    
}
