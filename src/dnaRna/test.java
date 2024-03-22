package dnaRna;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class test {
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		String seq="IVVSDEYIIDCSSR";
		
		
		
		
		   String[] dict=seq.split("");


	        HashSet<String> hs=new HashSet<String>();


	        int count=0;

	        String word="";

	        for(int j=0;j<dict.length;j++) {

	            word=dict[j];


	            for (int i = 0; i < dict.length; i++) {

	                if (dict[i].equalsIgnoreCase(word)) {

	                    count++;

	                }


	            }

//	            System.out.println(word+":"+countk);
	            hs.add(word+": "+count);
	            count=0;


	        }
	        
	        
	        
		System.out.println(hs);
		

    }

	

}
