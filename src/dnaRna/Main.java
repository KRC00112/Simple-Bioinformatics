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
		float gcContent=GcContentCalculation(dnaSeq);

		
		
		
		
		
		System.out.println("The DNA Sequence: "+dnaSeq);
		System.out.println("The length of the DNA Sequence: "+dnaSeq.length()+" Nucleotides");
		System.out.println("The RNA Sequence: "+rnaSeq);
		System.out.println("The Protein Sequence: "+proteinSeq);
		System.out.println("The Reverse Complement of the DNA Sequence: "+reverseComplement);
		System.out.println("The GC-Content of the DNA Sequence: "+gcContent+"%");



		

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
		
			
			for(int i=0;i<rnaLength;i+=3) {
				
				
				if(rnaLength%3!=0) {
					
					remainder=rnaLength%3;
					rnaLength=rnaLength-remainder;
					
					
					
				}
				
				
					
					aminoAcid=rnaSeq.substring(i, j);
					
					
					if(aminoAcid.equalsIgnoreCase("UUU")||aminoAcid.equalsIgnoreCase("UUC")) {
					
					
					
					
						aminoAcid="Phenylalanine";
						
					}
					
					if(aminoAcid.equalsIgnoreCase("UUA")||aminoAcid.equalsIgnoreCase("UUG")||aminoAcid.equalsIgnoreCase("CUU")||aminoAcid.equalsIgnoreCase("CUC")||aminoAcid.equalsIgnoreCase("CUA")||aminoAcid.equalsIgnoreCase("CUG")) {
						
						
						aminoAcid="Leucine";
						
					}
					
					if(aminoAcid.equalsIgnoreCase("AUU")||aminoAcid.equalsIgnoreCase("AUC")||aminoAcid.equalsIgnoreCase("AUA")) {
						
						aminoAcid="Isoleucine";

						
					}
					if(aminoAcid.equalsIgnoreCase("AUG")) {
						
						aminoAcid="Methionine";

						
					}
					if(aminoAcid.equalsIgnoreCase("GUU")||aminoAcid.equalsIgnoreCase("GUC")||aminoAcid.equalsIgnoreCase("GUA")||aminoAcid.equalsIgnoreCase("GUG")) {
						
						aminoAcid="Valine";

						
					}
					if(aminoAcid.equalsIgnoreCase("UCU")||aminoAcid.equalsIgnoreCase("UCC")||aminoAcid.equalsIgnoreCase("UCA")||aminoAcid.equalsIgnoreCase("UCG")||aminoAcid.equalsIgnoreCase("AGU")||aminoAcid.equalsIgnoreCase("AGC")) {
						
						aminoAcid="Serine";

						
					}
					if(aminoAcid.equalsIgnoreCase("CCU")||aminoAcid.equalsIgnoreCase("CCC")||aminoAcid.equalsIgnoreCase("CCA")||aminoAcid.equalsIgnoreCase("CCG")) {
						
						aminoAcid="Proline";

						
					}
					if(aminoAcid.equalsIgnoreCase("ACU")||aminoAcid.equalsIgnoreCase("ACC")||aminoAcid.equalsIgnoreCase("ACA")||aminoAcid.equalsIgnoreCase("ACG")) {
						
						aminoAcid="Threonine";

						
					}
					if(aminoAcid.equalsIgnoreCase("GCU")||aminoAcid.equalsIgnoreCase("GCC")||aminoAcid.equalsIgnoreCase("GCA")||aminoAcid.equalsIgnoreCase("GCG")) {
						
						aminoAcid="Alanine";

						
					}
					if(aminoAcid.equalsIgnoreCase("UAU")||aminoAcid.equalsIgnoreCase("UAC")) {
						
						aminoAcid="Tyrosine";

						
					}
					if(aminoAcid.equalsIgnoreCase("UAA")||aminoAcid.equalsIgnoreCase("UAG")||aminoAcid.equalsIgnoreCase("UGA")) {
						
						aminoAcid="*";

						
					}
					if(aminoAcid.equalsIgnoreCase("CAU")||aminoAcid.equalsIgnoreCase("CAC")) {
						
						aminoAcid="Histidine";

						
					}
					if(aminoAcid.equalsIgnoreCase("CAA")||aminoAcid.equalsIgnoreCase("CAG")) {
						
						aminoAcid="Glutamine";

						
					}
					if(aminoAcid.equalsIgnoreCase("AAU")||aminoAcid.equalsIgnoreCase("AAC")) {
						
						aminoAcid="Asparagine";

						
					}
					if(aminoAcid.equalsIgnoreCase("AAA")||aminoAcid.equalsIgnoreCase("AAG")) {
						
						aminoAcid="Lysine";

						
					}
					if(aminoAcid.equalsIgnoreCase("GAU")||aminoAcid.equalsIgnoreCase("GAC")) {
						
						aminoAcid="Aspartic acid";

						
					}
					if(aminoAcid.equalsIgnoreCase("GAA")||aminoAcid.equalsIgnoreCase("GAG")) {
						
						aminoAcid="Glutamic acid";

						
					}
					if(aminoAcid.equalsIgnoreCase("UGU")||aminoAcid.equalsIgnoreCase("UGC")) {
						
						aminoAcid="Cysteine";

						
					}
					if(aminoAcid.equalsIgnoreCase("UGG")) {
						
						aminoAcid="Tryptophan";

						
					}
					if(aminoAcid.equalsIgnoreCase("CGU")||aminoAcid.equalsIgnoreCase("CGC")||aminoAcid.equalsIgnoreCase("CGA")||aminoAcid.equalsIgnoreCase("CGG")||aminoAcid.equalsIgnoreCase("AGA")||aminoAcid.equalsIgnoreCase("AGG")) {
						
						aminoAcid="Arginine";

						
					}
					if(aminoAcid.equalsIgnoreCase("GGU")||aminoAcid.equalsIgnoreCase("GGC")||aminoAcid.equalsIgnoreCase("GGA")||aminoAcid.equalsIgnoreCase("GGG")) {
						
						aminoAcid="Glycine";

						
					}
					
					
					codon=codon+aminoAcid+" ";

					
					
					j+=3;
					
	
				
				
			}

		return codon;
	
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
	
	public static float GcContentCalculation(String dnaSeq) {
		
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
