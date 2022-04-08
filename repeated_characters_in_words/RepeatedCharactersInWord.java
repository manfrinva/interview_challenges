/*
This algorithm read all characters of a phrase or word.
Counts all characters and displays each one and the number of times it appears.
Example: "Interview". The output will be {i=2; n=1; t=2; r=1; v=1; s=1; a=1}
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.util.TreeMap;
 
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
        for(Map.Entry<String, Integer> a : items.entrySet()){
            System.out.println(a.getKey() + ": " +  a.getValue());
        }    
    } 
}