import java.util.Scanner;

public class DigitSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		int sm = sum(n);
		System.out.println("Sum of digits is " + sm);
		sc.close();
	}

	static int sum(int x) {
		if (x < 1) {
			return x;
		} else {
			return (x % 10 + sum(x / 10));
		}
	}
}
