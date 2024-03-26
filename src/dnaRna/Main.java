package dnaRna;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
        runApplication();
        long end = System.currentTimeMillis();
        System.out.println("\n\nTotal Runtime: "+(end - start) + " ms");
		
		
		
	}
	

	public static void runApplication() {
		// TODO Auto-generated method stub
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the DNA Sequence: ");
		String dnaSeq=scanner.nextLine();
		
		if(!dnaSeq.matches("[atgc\s]+")) {
			
			
			System.out.println("Enter a valid DNA Sequence");
			
		}
		
		
		
	
		else {	
		
		
			dnaSeq=dnaSeq.replace(" ", "");
			dnaSeq=dnaSeq.toUpperCase();
			ArrayList codonList=codons(dnaSeq);
			String rnaSeq=transcription(dnaSeq);
			String proteinSeq=translation(rnaSeq);
			String reverseComplement=reverseComplementOfDna(dnaSeq);
			float gcContent=gcContentCalculation(dnaSeq);
			System.out.println("The DNA Sequence                                 : "+dnaSeq);
			System.out.println("The length of the DNA Sequence                   : "+dnaSeq.length()+" Nucleotides");
			System.out.println("The Nucleotide Frequency of the DNA Sequence     : "+nucleotideFrequency(dnaSeq));
			System.out.println("Codons That can be formed from the DNA Sequence  : "+codonList+"["+codonList.size()+"]");
			System.out.println("The Codon Frequency of the DNA Sequence          : "+codonFrequency(codonList));
			System.out.println("The Reverse Complement of the DNA Sequence       : "+reverseComplement);
			System.out.println("The GC-Content of the DNA Sequence               : "+gcContent+"%");
			System.out.println("The RNA Sequence                                 : "+rnaSeq);
	//		System.out.println("The Nucleotide Frequency of the RNA Sequence     : "+nucleotideFrequency(rnaSeq));
			System.out.println("The Protein Sequence                             : "+proteinSeq);
			System.out.println("The Amino Acid Frequency of the Protein Sequence : "+aminoAcidFrequency(proteinSeq));
		
		
		}

	}
	
	
	public static HashSet aminoAcidFrequency(String seq) {
		

		   String[] dict=seq.split("");
	        HashSet<String> hs=new HashSet<String>();
	
			if(seq.isEmpty()) {
				
				
				hs.add("empty");
				
				return hs;
				
				
			}

			else {
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
		        
		        
		        		
			return hs;
		
			}
		

    }
	
	
	
	public static ArrayList codons(String seq) {
		
		
		int seqLength=seq.length();
		int remainder=0;
		
			if(seqLength%3!=0) {
				
				remainder=seqLength%3;
				seqLength=seqLength-remainder;
				
	
			}
	
		
			int j=0;
	        String singleCodon="";
	        
	        

	        ArrayList <String> codons=new ArrayList<>();

	        for(int i=0;i<seqLength;i+=3){

	            j=i+3;

	            singleCodon=seq.substring(i,j);

	            codons.add(singleCodon);



	        }

		return codons;
		
	}
	
	
	
	
	
	
	public static LinkedList nucleotideFrequency(String seq) {
		
		
		
		int countA=0;
		int countT=0;
		int countG=0;
		int countC=0;
		int countU=0;
		
		LinkedList<String> nd=new LinkedList<String>();
		
		
		char[] nucleotides= {'A','T','G','C','U'};
		
		for(int i=0;i<seq.length();i++) {
			
			if(seq.charAt(i)=='A') {
				countA++;
			}
			 if(seq.charAt(i)=='T') {
				countT++;

			}
			 if(seq.charAt(i)=='G') {
				countG++;

			}
			 if(seq.charAt(i)=='C') {
				
				
				countC++;

			}
			 if(seq.charAt(i)=='U') {
				countU++;

			}
			
			
			
			
		}
		
		nd.add("count of A: "+countA);
		nd.add("count of G: "+countG);
		nd.add("count of C: "+countC);
		
		if(seq.contains("U")) {
			nd.add("count of U: "+countU);
		}
		
		
		else {
			nd.add("count of T: "+countT);
		}
	
		
		
		
		return nd;



		
		
		
	}
	
	
	
	public static HashSet codonFrequency(ArrayList codonList) {
		
		
		

		String stringCodons=codonList.toString();
		
		
        String[] syms={"[","]",","};

		
		for(String i :syms){


			stringCodons=stringCodons.replace(i,"");


        }
		
		
		
		
        String[] dict=stringCodons.split(" ");


        HashSet<String> hs=new HashSet<String>();
        
        
        if(stringCodons.isEmpty()) {
			
			
			hs.add("empty");
			
			return hs;
			
			
		}
        
        
        else {


	        int count=0;
	
	        String word="";
	
	        for(int j=0;j<dict.length;j++) {
	
	            word=dict[j];
	
	
	            for (int i = 0; i < dict.length; i++) {
	
	                if (dict[i].equalsIgnoreCase(word)) {
	
	                    count++;
	
	                }
	
	
	            }
	
	//            System.out.println(word+":"+countk);
	            hs.add(word+": "+count);
	            count=0;
	
	
	        }
	
	
	
	//        for(String i: hs){
	//
	//            System.out.println(i);
	//
	//
	//
	//        }		
			
			return hs;
		
        }
		
		
		
		
		
	}
	
	public static String transcription(String dnaSeq) {
		String rnaSeq=dnaSeq.replace('T', 'U');
		return rnaSeq;	
	}
	
	
	
	
	public static String translation(String rnaSeq) {
		
		String codon="";
		int j=3;
		String aminoAcid="";
		int remainder=0;
		int rnaLength=rnaSeq.length();

		if(rnaLength%3!=0) {
			
			remainder=rnaLength%3;
			rnaLength=rnaLength-remainder;
			

		}
	
		for(int i=0;i<rnaLength;i+=3) {
		
				
					
					codon=rnaSeq.substring(i, j);
					
					
					if(codon.equalsIgnoreCase("UUU")||codon.equalsIgnoreCase("UUC")) {

//						codon="Phenylalanine";
						codon="F";
						
					}
					
					if(codon.equalsIgnoreCase("UUA")||codon.equalsIgnoreCase("UUG")||codon.equalsIgnoreCase("CUU")||codon.equalsIgnoreCase("CUC")||codon.equalsIgnoreCase("CUA")||codon.equalsIgnoreCase("CUG")) {
						
//						codon="Leucine";
						codon="L";
					}
					
					if(codon.equalsIgnoreCase("AUU")||codon.equalsIgnoreCase("AUC")||codon.equalsIgnoreCase("AUA")) {
						
//						codon="Isoleucine";
						codon="I";
						
					}
					if(codon.equalsIgnoreCase("AUG")) {
						
//						codon="Methionine";
						codon="M";
						
					}
					if(codon.equalsIgnoreCase("GUU")||codon.equalsIgnoreCase("GUC")||codon.equalsIgnoreCase("GUA")||codon.equalsIgnoreCase("GUG")) {
						
//						codon="Valine";
						codon="V";
						
					}
					if(codon.equalsIgnoreCase("UCU")||codon.equalsIgnoreCase("UCC")||codon.equalsIgnoreCase("UCA")||codon.equalsIgnoreCase("UCG")||codon.equalsIgnoreCase("AGU")||codon.equalsIgnoreCase("AGC")) {
						
//						codon="Serine";
						codon="S";
						
					}
					if(codon.equalsIgnoreCase("CCU")||codon.equalsIgnoreCase("CCC")||codon.equalsIgnoreCase("CCA")||codon.equalsIgnoreCase("CCG")) {
						
//						codon="Proline";
						codon="P";

						
					}
					if(codon.equalsIgnoreCase("ACU")||codon.equalsIgnoreCase("ACC")||codon.equalsIgnoreCase("ACA")||codon.equalsIgnoreCase("ACG")) {
						
//						codon="Threonine";
						codon="T";
						
					}
					if(codon.equalsIgnoreCase("GCU")||codon.equalsIgnoreCase("GCC")||codon.equalsIgnoreCase("GCA")||codon.equalsIgnoreCase("GCG")) {
						
//						codon="Alanine";
						codon="A";

					}
					if(codon.equalsIgnoreCase("UAU")||codon.equalsIgnoreCase("UAC")) {
						
//						codon="Tyrosine";
						codon="Y";

					}
					if(codon.equalsIgnoreCase("UAA")||codon.equalsIgnoreCase("UAG")||codon.equalsIgnoreCase("UGA")) {
						
						codon="*";	
					}
					if(codon.equalsIgnoreCase("CAU")||codon.equalsIgnoreCase("CAC")) {
						
//						codon="Histidine";
						codon="H";

						
					}
					if(codon.equalsIgnoreCase("CAA")||codon.equalsIgnoreCase("CAG")) {
						
//						codon="Glutamine";
						codon="Q";

						
					}
					if(codon.equalsIgnoreCase("AAU")||codon.equalsIgnoreCase("AAC")) {
						
//						codon="Asparagine";
						codon="N";

						
					}
					if(codon.equalsIgnoreCase("AAA")||codon.equalsIgnoreCase("AAG")) {
						
//						codon="Lysine";
						codon="K";

						
					}
					if(codon.equalsIgnoreCase("GAU")||codon.equalsIgnoreCase("GAC")) {
						
//						codon="Aspartic_acid";
						codon="D";

						
					}
					if(codon.equalsIgnoreCase("GAA")||codon.equalsIgnoreCase("GAG")) {
						
//						codon="Glutamic_acid";
						codon="E";

						
					}
					if(codon.equalsIgnoreCase("UGU")||codon.equalsIgnoreCase("UGC")) {
						
//						codon="Cysteine";
						codon="C";

						
					}
					if(codon.equalsIgnoreCase("UGG")) {
						
//						codon="Tryptophan";
						codon="W";

						
					}
					if(codon.equalsIgnoreCase("CGU")||codon.equalsIgnoreCase("CGC")||codon.equalsIgnoreCase("CGA")||codon.equalsIgnoreCase("CGG")||codon.equalsIgnoreCase("AGA")||codon.equalsIgnoreCase("AGG")) {
						
//						codon="Arginine";
						codon="R";

						
					}
					if(codon.equalsIgnoreCase("GGU")||codon.equalsIgnoreCase("GGC")||codon.equalsIgnoreCase("GGA")||codon.equalsIgnoreCase("GGG")) {
						
//						codon="Glycine";
						codon="G";

						
					}
					
					
					aminoAcid=aminoAcid+codon+"";

					
					
					j+=3;
					
	
				
				
			}

		return aminoAcid;
	
	}
	public static String reverseComplementOfDna(String dnaSeq) {
		
		
		String store="";
		char nucleotide;
		
		for(int i=dnaSeq.length()-1;i>=0;i--) {
			
			nucleotide=dnaSeq.charAt(i);
			
			if(nucleotide=='A') {
				nucleotide='T';
			}
			else if(nucleotide=='T') {
				nucleotide='A';
			}
			else if(nucleotide=='G') {
				nucleotide='C';
			}
			else if(nucleotide=='C') {
				nucleotide='G';
			}
			
			store=store+nucleotide;
			
		}
		
		
		
		
		
		
		
		return store;
		
	}
	
	public static float gcContentCalculation(String dnaSeq) {
		
		int countG=0;
		int countC=0;
		int countA=0;
		int countT=0;
		float gcContent ;

		
		for(int i=0;i<dnaSeq.length();i++) {
			
			
			if(dnaSeq.charAt(i)=='G') {
				
				countG++;
				
				
			}
			else if(dnaSeq.charAt(i)=='C') {
				
				countC++;
				
				
			}
			else if(dnaSeq.charAt(i)=='A') {
				
				countA++;
				
				
			}
			else if(dnaSeq.charAt(i)=='T') {
				
				countT++;
				
				
			}
			
			
			
		}
		
		
		gcContent=((float)(countG+countC)/(countG+countC+countT+countA))*100;

		
		return gcContent;
	}
	
	


}
