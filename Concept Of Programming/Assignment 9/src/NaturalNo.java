import java.util.Scanner;

public class NaturalNo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		nat(n,1);
		sc.close();
	}
	static int nat(int a,int b) {
		if(b<=a) {
		System.out.print(b+" ");
		return nat(a,b+1);
	}
		return 1;
	}

}
