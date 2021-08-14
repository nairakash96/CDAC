import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value of x and n");
		int x=sc.nextInt();
		int n=sc.nextInt();
		int p=pow(x,n);
		System.out.println("Power of "+x+" to "+n+" is "+p);
		sc.close();
	}
static int pow(int a,int b) {
	if(b<1)
		return 1;
	else
	return a*pow(a,b-1);
}
}
