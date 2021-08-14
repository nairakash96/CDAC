
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter value of  n ");
		int n=sc.nextInt();
		int f=fact(n);
		System.out.println("Factorial of "+n+" is "+f);
		sc.close();
	}
	static int fact(int x) {
		if(x<=1)
			return 1;
		return x*fact(x-1);
	}

}
