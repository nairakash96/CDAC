import java.util.Scanner;

public class NumUtilChoice {

	public static void main(String[] args) {
			Scanner sc =new Scanner(System.in);
			char c;
			do {
				System.out.println("Enter your choice");
				System.out.println("1.Power\n2.Factorial\n3.Is_Even\n4.Is_Odd\n5.Is_Prime");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:System.out.println("Enter two numbers");
				 		int a=sc.nextInt();
				 		int b=sc.nextInt();
						System.out.println(b+" power of "+a+" is "+NumUtil.getPower(a,b));
						break;
				case 2:System.out.println("Enter a numbers");
						int n=sc.nextInt();
						System.out.println("Factorial of "+n+" is "+NumUtil.getFactorial(n));
						break;
				case 3:System.out.println("Enter a numbers");
						int n1=sc.nextInt();
						NumUtil.isEven(n1);
						break;
				case 4:System.out.println("Enter a numbers");
						int n2=sc.nextInt();
						NumUtil.isOdd(n2);
						break;
				case 5:System.out.println("Enter a numbers");
						int n3=sc.nextInt();
						NumUtil.isPrime(n3);
						break;
				default: System.out.println("Enetr a valid input");
						break;
				}
				System.out.println("Do you want to continue Y/N");
				c=sc.next().charAt(0);
			}while(c=='Y'||c=='y');
				sc.close();
				}
}