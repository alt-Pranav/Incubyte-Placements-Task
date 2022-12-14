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

        String delim = ",";
        // -1 means normal, 0 means odd indices and 1 means even indices
        int indices=-1; 

        if(numbers.contains("0//")){
            indices = 0;
        }

        if(numbers.contains("1//")){
            indices = 1;
        }

        if(numbers.contains("//")){
            if(numbers.contains("[")){
                delim = numbers.substring(numbers.indexOf("[")+1, numbers.indexOf("]"));
                //System.out.println("DELIM = "+delim);
                numbers = numbers.substring(numbers.indexOf("]")+1);
            }
            else if(!Pattern.compile("^[a-zA-Z0-9]+$").matcher(String.valueOf(numbers.charAt(2))).matches()){
                delim = indices == -1 ? String.valueOf(numbers.charAt(2)) : String.valueOf(numbers.charAt(3));
                numbers = indices == -1 ? numbers.substring(3) : numbers.substring(5);
            }
            else{
                delim = ",";
                numbers = numbers.substring(3); 
            }
        }

        String numList[] = numbers.split("[" + delim + "]+");
        ArrayList<String> negatives = new ArrayList<String>();
        int flag=0; // switched to 1 if negative numbers are present
        for(String i : numList){
        
            if(i != ""){

                if(i.contains("\n")){
                    String temp[] = i.split("\n");
                    i="";
                    for(String t : temp){
                        i+= t + ",";
                    }
                    sum += add(i.substring(0, i.length()));
                }

                // if lower case alphabet
                if(flag==0 && Pattern.compile("^[a-z]+$").matcher(i).matches()){
                    // a = 1, ..,  z=26
                    if((indices == 0) && (numbers.indexOf(i) % 2 == 0)){continue;}
                    if((indices == 1) && (numbers.indexOf(i) % 2 != 0)){continue;}
                    sum += i.charAt(0) - 97 + 1;
                }

                // if number 
                else if(flag==0 && Pattern.compile("^[0-9]+$").matcher(i).matches())
                {
                    if(Integer.parseInt(i) > 1000){continue;}
                    if((indices == 0) && (numbers.indexOf(i) % 2 == 0)){continue;}
                    if((indices == 1) && (numbers.indexOf(i) % 2 != 0)){continue;}
                    
                    sum += Integer.parseInt(i);
                }

                // if negative number
                else if(Pattern.compile("^[-]?\\d*$").matcher(i).matches()){
                    if(Integer.parseInt(i) >= 0){continue;}
                    negatives.add(i); // to keep track of all negative nums
                    flag=1;
                }
            }
        }

        if(flag==1){
            throw new Exception("Negatives not allowed: "+negatives.toString());
        }
        
        return sum;
    }

}