import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *  Function Defn: int add(String numbers)
 *  Cases:
 *  1. Returns 0 for empty string (so 0 for null as well)
 *  2. For a single number it will return that number
 *  3. for input "1,2" output is 3
 *  4. for Input: "1,2,a,c" Output: 7 (1 + 2 + 1 + 3) (only consider lowercase alphabets)
 *  5. Numbers bigger than 1000 should be ignored.
 */

public class StringCalculator{

    static int add(String numbers)throws Exception{

        int sum=0;

        if(numbers == null){return sum;}
        if(numbers == ""){return sum;}

        String numList[] = numbers.split(",");
        for(String i : numList){

            if(i != ""){

                // if lower case alphabet
                if(Pattern.compile("^[a-z]+$").matcher(i).matches()){
                    // a = 1, ..,  z=26
                    sum += i.charAt(0) - 97 + 1;
                }

                // if number 
                else if(Pattern.compile("^[0-9]+$").matcher(i).matches())
                {
                    if(Integer.parseInt(i) > 1000){continue;}
                    sum += Integer.parseInt(i);
                }

                // if negative number
                else if(Pattern.compile("^[-]?\\d*$").matcher(i).matches()){
                    if(Integer.parseInt(i) >= 0){continue;}
                    throw new Exception("Negatives not allowed: "+i);
                }
            }
            //System.out.print(i+" ");
        }
        //System.out.println(" and " + sum);
        return sum;
    }

}