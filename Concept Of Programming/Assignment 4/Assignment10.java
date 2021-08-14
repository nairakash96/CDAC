import java.util.*;
class Assignment10{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int i,j;
	for(i=1;i<=5;i++){
		for(j=5-i;j>=1;j--){
			System.out.print(" ");
		}
		for (j=1;j<=i;j++){
			System.out.print(" "+i);
		}
	System.out.println();
	}

	for(i=1;i<=5;i++){
		for(j=5-i;j>=1;j--){
			System.out.print(" ");
		}
		for (j=1;j<=i;j++){
			System.out.print(" "+j);
		}
	System.out.println();
	}
}
}