public class StringCalculatorTest {

    private final static String TEST_ONE = "NULL STRING";
    private final static String TEST_TWO = "EMPTY STRING";
    private final static String TEST_THREE = "VALID STRING";

    private final static String SUCCESS = " TEST was successful";
    private final static String FAIL = " TEST has failed";

    public static void main(String args[]){
        testAdd();
    }

    static void testAdd(){
        // null check
        if(StringCalculator.add(null) == 0) {logTest(TEST_ONE, SUCCESS);}
        else {logTest(TEST_ONE, FAIL);}

        // empty string check
        if(StringCalculator.add("") == 0) {logTest(TEST_TWO, SUCCESS);}
        else {logTest(TEST_TWO, FAIL);}

        // valid number check
        if(StringCalculator.add("11,222,3") == 236){logTest(TEST_THREE, SUCCESS);}
        else {logTest(TEST_THREE, FAIL);}
    }

    static void logTest(String TEST, String STATE){
        System.out.println(TEST + STATE);
    }
    
}
