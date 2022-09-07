/**
 *  Function Defn: int add(String numbers)
 *  Cases:
 *  1. Returns 0 for empty string (so 0 for null as well)
 *  2. For a single number it will return that number
 *  3. for input "1,2" output is 3
 *  4. for Input: "1,2,a,c" Output: 7 (1 + 2 + 1 + 3) (only consider lowercase alphabets)
 */

public class StringCalculator{

    static int add(String numbers){

        int sum=0;

        if(numbers == null){return sum;}
        if(numbers == ""){return sum;}

        String numList[] = numbers.split(",");
        for(String i : numList){
            if(i != ""){
                sum += Integer.parseInt(i);
            }
            //System.out.print(i+" ");
        }
        //System.out.println(" and " + sum);
        return sum;
    }

}