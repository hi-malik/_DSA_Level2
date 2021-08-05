package ConceptualBuildingBlocks.RecursionAndBacktracking;

import java.io.*;
import java.util.*;

public class AllPalindromicPartitions {

	public static void solution(String str, String asf) {
		//write you code here
		if(str.length() == 0){
		    System.out.println(asf);
		    return;
		}
		for(int i = 0; i < str.length(); i++){
		    String prefix = str.substring(0, i + 1);
		    String ros = str.substring(i + 1);
		    if(isPalindromic(prefix)){
		        solution(ros, asf + "(" + prefix + ") ");
		    }
		}
	}
	public static boolean isPalindromic(String str){
	    int li = 0;
	    int ri = str.length() - 1;
	    
	    while(li <= ri){
	        char ch1 = str.charAt(li);
	        char ch2 = str.charAt(ri);
	        
	        if(ch1 != ch2){
	            return false;
	        }
	        li++;
	        ri--;
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}