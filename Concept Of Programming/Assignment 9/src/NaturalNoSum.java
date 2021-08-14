import java.util.Scanner;

public class NaturalNoSum {
	static int sm;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int num=nat(n,1);
		System.out.println("Sum="+num);
		sc.close();
	}
	static int nat(int a,int b) {
		if(b<=a) {
		sm+=b;
		nat(a,b+1);
	}
		return sm;
	}

}
