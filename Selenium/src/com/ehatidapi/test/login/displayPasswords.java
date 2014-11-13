package com.ehatidapi.test.login;


public class displayPasswords {

	
	public static final int LENGTH=5; // the length of passwords we want to generate
	public static String passWordGen(String currentPass,char c){    
		
	    if(c<='~'){
	      // System.out.println(currentPass+c);
	        passWordGen(currentPass,(char)(c+1)); //go through every character at this position
	        
	        if(currentPass.length()<LENGTH-1){
	            passWordGen(currentPass+c,'!'); //start over by adding the current charterer to the current postion
	        }
	    }   
	    return currentPass+c;
	}
	public static void main(String[] args) {        
	        passWordGen("",'!'); // kick off the recursion with an empty string and the first character         
	}

}
