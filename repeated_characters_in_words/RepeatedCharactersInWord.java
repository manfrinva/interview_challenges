import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.util.TreeMap;
 
//Algorithm that shows the repeated characters in a sentence or words
public class RepeatedCharactersInWord{
	public static void main (String[] args) throws java.lang.Exception{
	    //is possible change this variable for any kind of words or phrase.
		String s = "Interview";
        Map<String, Integer> map = contar(s.replace(" ", "").toLowerCase());
        Imprimir(map);
	}
	
	public static Map<String, Integer> contar(String frase){        
        Map<String, Integer> map = new TreeMap<>();                
        
        for(char item : frase.toCharArray()){
            Integer s = map.get(String.valueOf(item));
            if (s != null){
                map.put(String.valueOf(item), ++s);
            } else {
                map.put(String.valueOf(item), 1);
            }
        }
        return map;
    }
 
    public static void Imprimir(Map<String, Integer> items){       
    	//A variable to show in which you choose the minimum number of times the character appears in order to show it
        int numberOfTimes = 2;
        
        //A variable count the lines showed
        int lines = 0;
        
	    //for to show the chars;
        for(Map.Entry<String, Integer> a : items.entrySet()){
            
            //if to validate the minimun number
            if(a.getValue()>=numberOfTimes){
                System.out.println(a.getKey() + ": " +  a.getValue());
                lines++;//if showed line own +1
            }
        }
        if (lines==0){
            System.out.println("There are no repeating characters");
        }   
    } 
}
