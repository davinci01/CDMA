import java.util.*;


public class CDMA {
	
	// variables 
	
	Scanner sc= new Scanner(System.in);
	int [] code1 =new int[]{1,-1,1,1,1,-1,1,1};
	int [] code2 =new int[]{1,1,1,-1,1,-1,-1,-1};
	int [] r1 =new int[8];
	int [] r2 =new int[8];
	int decoded_S1=0;
	int decoded_S2=0;
	
	//encode function
	public byte binary_to_string(String S){
		byte a=0;
		
		return a;
	}
	public void station () {
		
		//get station 1 and station 2 as an input
		System.out.print("enter Station 1: ");
		int S1=sc.nextInt();
		System.out.print("enter Station 2: ");
		int S2=sc.nextInt();
		
		//test for confirm that values are binary
		if((S1!=0 && S1!=1)||(S2!=0 &&S2!=1 ) ) {
			System.out.println("enter a valid binary numbers !!");
			station();
			return;
		}
		
		//replace 0 with -1
		if(S1==0){
			S1=-1;
		}
		if(S2==0) {
			S2=-1;
		}
		
		//get 8 bits binary sequence
		for(int i=0;i<8;i++) {
			
			r1[i]=code1[i]*S1;
		}
		for(int i=0;i<8;i++) {
			r2[i]=code2[i]*S2;
		}
		
		//get 16 bit binary sequence
		int lenr1=r1.length;
		int lenr2=r2.length;
		int [] cdmres= new int[lenr1 + lenr2];
		System.arraycopy(r1, 0, cdmres, 0, lenr1);
		System.arraycopy(r2, 0, cdmres, lenr1, lenr2);
		System.out.println("bites sequence :  "+Arrays.toString(cdmres));
	}
	
	//decode function
	public void decoder() {
		
		for(int i=0;i<8;i++) {
			decoded_S1=r1[i]* code1[i]+decoded_S1;
		}
		decoded_S1=decoded_S1/8;
		
		for(int i=0;i<8;i++) {
			decoded_S2=r2[i]* code2[i]+decoded_S2;
		}
		decoded_S2=decoded_S2/8;
		
		if(decoded_S1==-1){
			decoded_S1=0;
		}
		if(decoded_S2==-1) {
			decoded_S2=0;
		}
		System.out.println("decoded station 1 :"+decoded_S1);
		System.out.println("decoded station 2 :"+decoded_S2);
	}
	

}
