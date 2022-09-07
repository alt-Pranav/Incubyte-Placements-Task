public class StringCalculatorTest {

    private final static String TEST_ONE = "NULL STRING";
    private final static String TEST_TWO = "EMPTY STRING";

    private final static String TEST_THREE = "VALID NUM STRING";
    private final static String TEST_FOUR = "INVALID NUM STRING";

    private final static String TEST_FIVE = "VALID ALPHA STRING";
    private final static String TEST_SIX = "INVALID ALPHA STRING";

    private final static String TEST_SEVEN = "NEGATIVE NUM STRING";

    private final static String TEST_EIGHT = "NEWLINE NUM STRING";

    private final static String TEST_NINE = "NEW DELIMITER STRING";

    private final static String SUCCESS = " TEST was successful";
    private final static String FAIL = " TEST has failed";

    public static void main(String args[])throws Exception{
        testValidInputs();
        testInvalidInputs();
    }

    /**
     * Here, if output matches for valid input then it is considered success
     */
    static void testValidInputs()throws Exception{
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

        // valid alphabets check
        if(StringCalculator.add("1,a,b,z") == 30){logTest(TEST_FIVE, SUCCESS);}
        else {logTest(TEST_FIVE, FAIL);}

        // contains "\n"
        if(StringCalculator.add("1\n2,3,a\n1") == 8){logTest(TEST_EIGHT, SUCCESS);}
        else {logTest(TEST_EIGHT, FAIL);}

        // new delimiter
        if(StringCalculator.add("//;\n1;2;a") == 4){logTest(TEST_NINE, SUCCESS);}
        else {logTest(TEST_NINE, FAIL);}
    }

    /**
     * Here, if output matches for invalid input, then it is considered success
     */
    static void testInvalidInputs()throws Exception{
        // invalid number check
        // numbers bigger than 1000 must be ignored
        if(StringCalculator.add("11,2222,3") == 14){logTest(TEST_FOUR, SUCCESS);}
        else {logTest(TEST_FOUR, FAIL);}

        // invalid alphabets check
        if(StringCalculator.add("1,A,a,b,z") == 30){logTest(TEST_SIX, SUCCESS);}
        else {logTest(TEST_SIX, FAIL);}

        // negative numbers check
        try{
            int result = StringCalculator.add("1,-1,9,-2,5,-7");
        }
        catch(Exception e){
            if(e.getMessage().contains("Negatives not allowed"))
            {
                System.out.println(e.getMessage());
                logTest(TEST_SEVEN, SUCCESS);
            }
            else {logTest(TEST_SEVEN, FAIL);}
        }
    }

    static void logTest(String TEST, String STATE){
        System.out.println(TEST + STATE);
    }
    
}
