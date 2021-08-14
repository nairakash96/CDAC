import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two number");
		int num1=sc.nextInt(2);
		int num2=sc.nextInt(2);
		System.out.println("Num1= "+num1);
		System.out.println("Num2= "+num2);
		int sum=num1+num2;
		System.out.println("Sum= "+sum);
		System.out.println("Binary Formate");
		System.out.println("Num1= "+Integer.toBinaryString(num1));
		System.out.println("Num2= "+Integer.toBinaryString(num2));
		System.out.println("Sum= "+Integer.toBinaryString(sum));
		
		sc.close();
	}

}
