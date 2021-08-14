import java.util.Scanner;

public class NumUtilMain {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter value of n");
	int a=sc.nextInt();
	int b=sc.nextInt();
	NumUtil.getPower(a,b);
	NumUtil.getFactorial(a);
	NumUtil.isEven(a);
	NumUtil.isOdd(b);
	NumUtil.isPrime(b);
	sc.close();
	System.out.println(b+" power of "+a+" is "+NumUtil.getPower(a,b)+"\n Factorial of "+a+" is "+NumUtil.getFactorial(a));
	
}
}
