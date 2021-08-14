
public class NumUtil {
	static double getPower(int a, int b) {
		return Math.pow(a, b);
	}

	static long getFactorial(int num) {
		if(num<=1)
			return 1;
		else
			return num*getFactorial(num-1);
	}

	static void isPrime(int a) {
		int flag=1;
		for(int i=2;i<a;i++) {
			if(a%i==0) {
				flag=0;
			}
		}
		if(flag==1||a==2) {
			System.out.println(a+" is Prime");
		}
		else {
			System.out.println(a+" is not Prime");
		}
	}

	static void isEven(int num) {
		if(num%2==0)
			System.out.println(num+" is Even");
		else {
			System.out.println(num+ " is not Even");
		}
	}

	static void isOdd(int num) {
		if(num%2==1) {
		System.out.println(num+" is a Odd No");
	}
	else
		System.out.println(num+" is a Even no");
	}
}
