import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two integer ");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int product=getProduct(num1,num2);
		System.out.println("Product ="+product);
		sc.close();
	}
	static int getProduct(int num1,int num2) {
		if(num1==0||num2==0)
			return 0;
	return num1 + getProduct(num1,num2-1);
	}

}
