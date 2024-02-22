package dnaRna;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the DNA Sequence: ");
		String dnaSeq=scanner.nextLine();
		dnaSeq=dnaSeq.toUpperCase();
		String rnaSeq=transcription(dnaSeq);
		String proteinSeq=translation(rnaSeq);
		String reverseComplement=reverseComplementOfDna(dnaSeq);
		float gcContent=gcContentCalculation(dnaSeq);
		System.out.println("The DNA Sequence                          : "+dnaSeq);
		System.out.println("The length of the DNA Sequence            : "+dnaSeq.length()+" Nucleotides");
		System.out.println("The RNA Sequence                          : "+rnaSeq);
		System.out.println("The Protein Sequence                      : "+proteinSeq);
		System.out.println("The Reverse Complement of the DNA Sequence: "+reverseComplement);
		System.out.println("The GC-Content of the DNA Sequence        : "+gcContent+"%");
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

						codon="Phenylalanine";
						
					}
					
					if(codon.equalsIgnoreCase("UUA")||codon.equalsIgnoreCase("UUG")||codon.equalsIgnoreCase("CUU")||codon.equalsIgnoreCase("CUC")||codon.equalsIgnoreCase("CUA")||codon.equalsIgnoreCase("CUG")) {
						
						codon="Leucine";
					}
					
					if(codon.equalsIgnoreCase("AUU")||codon.equalsIgnoreCase("AUC")||codon.equalsIgnoreCase("AUA")) {
						
						codon="Isoleucine";
						
					}
					if(codon.equalsIgnoreCase("AUG")) {
						
						codon="Methionine";
						
					}
					if(codon.equalsIgnoreCase("GUU")||codon.equalsIgnoreCase("GUC")||codon.equalsIgnoreCase("GUA")||codon.equalsIgnoreCase("GUG")) {
						
						codon="Valine";
						
					}
					if(codon.equalsIgnoreCase("UCU")||codon.equalsIgnoreCase("UCC")||codon.equalsIgnoreCase("UCA")||codon.equalsIgnoreCase("UCG")||codon.equalsIgnoreCase("AGU")||codon.equalsIgnoreCase("AGC")) {
						
						codon="Serine";
						
					}
					if(codon.equalsIgnoreCase("CCU")||codon.equalsIgnoreCase("CCC")||codon.equalsIgnoreCase("CCA")||codon.equalsIgnoreCase("CCG")) {
						
						codon="Proline";

						
					}
					if(codon.equalsIgnoreCase("ACU")||codon.equalsIgnoreCase("ACC")||codon.equalsIgnoreCase("ACA")||codon.equalsIgnoreCase("ACG")) {
						
						codon="Threonine";
						
					}
					if(codon.equalsIgnoreCase("GCU")||codon.equalsIgnoreCase("GCC")||codon.equalsIgnoreCase("GCA")||codon.equalsIgnoreCase("GCG")) {
						
						codon="Alanine";

					}
					if(codon.equalsIgnoreCase("UAU")||codon.equalsIgnoreCase("UAC")) {
						
						codon="Tyrosine";

					}
					if(codon.equalsIgnoreCase("UAA")||codon.equalsIgnoreCase("UAG")||codon.equalsIgnoreCase("UGA")) {
						
						codon="*";	
					}
					if(codon.equalsIgnoreCase("CAU")||codon.equalsIgnoreCase("CAC")) {
						
						codon="Histidine";

						
					}
					if(codon.equalsIgnoreCase("CAA")||codon.equalsIgnoreCase("CAG")) {
						
						codon="Glutamine";

						
					}
					if(codon.equalsIgnoreCase("AAU")||codon.equalsIgnoreCase("AAC")) {
						
						codon="Asparagine";

						
					}
					if(codon.equalsIgnoreCase("AAA")||codon.equalsIgnoreCase("AAG")) {
						
						codon="Lysine";

						
					}
					if(codon.equalsIgnoreCase("GAU")||codon.equalsIgnoreCase("GAC")) {
						
						codon="Aspartic_acid";

						
					}
					if(codon.equalsIgnoreCase("GAA")||codon.equalsIgnoreCase("GAG")) {
						
						codon="Glutamic_acid";

						
					}
					if(codon.equalsIgnoreCase("UGU")||codon.equalsIgnoreCase("UGC")) {
						
						codon="Cysteine";

						
					}
					if(codon.equalsIgnoreCase("UGG")) {
						
						codon="Tryptophan";

						
					}
					if(codon.equalsIgnoreCase("CGU")||codon.equalsIgnoreCase("CGC")||codon.equalsIgnoreCase("CGA")||codon.equalsIgnoreCase("CGG")||codon.equalsIgnoreCase("AGA")||codon.equalsIgnoreCase("AGG")) {
						
						codon="Arginine";

						
					}
					if(codon.equalsIgnoreCase("GGU")||codon.equalsIgnoreCase("GGC")||codon.equalsIgnoreCase("GGA")||codon.equalsIgnoreCase("GGG")) {
						
						codon="Glycine";

						
					}
					
					
					aminoAcid=aminoAcid+codon+" ";

					
					
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
