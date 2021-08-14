/*Write a menu driven billing system for a Snacks center, items available are Tea(Rs. 10), Samosa (Rs. 20), Sandwitch(Rs. 50), Green Tea (Rs. 15) etc. as follows - 

****Welcome to Snack Center *********
1. Tea (Rs. 10)
2. Green Tea (Rs. 15)
3. Samosa (Rs. 20)
4. Sandwitch (Rs. 50)
5. Generate Bill & Exit
*/
import java.util.*;

public class Order {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch,amt=0,qnt,qnti=0;
		String item[]= {"Tea\t","Green Tea","Samosa\t","Sandwitch"};
		int pri[]=new int[4];
		pri[0]=10;
		pri[1]=15;
		pri[2]=20;
		pri[3]=50;
		int cont[]=new int[4];
		do {
			System.out.println("****Welcome to Snack Center ****");
			System.out.println("1.Tea (Rs. 10)\n2.Green Tea (Rs. 15)\n3.Samosa (Rs. 20)\n4.Sandwitch (Rs. 50)\n5.Generate Bill and Exit");
			System.out.print("Enter your choice: ");
			ch=sc.nextInt();
			switch(ch) {
				case 1: System.out.print("Enter the quantity ");
						qnt=sc.nextInt();
						amt+=qnt*pri[0];
						cont[0]+=qnt;
						break;
				case 2: System.out.print("Enter the quantity ");
						qnt=sc.nextInt();
						amt+=qnt*pri[1];
						cont[1]+=qnt;
						break;
				case 3: System.out.print("Enter the quantity ");
						qnt=sc.nextInt();
						amt+=qnt*pri[2];
						cont[2]+=qnt;
						break;
				case 4: System.out.print("Enter the quantity ");
						qnt=sc.nextInt();
						amt+=qnt*pri[3];
						cont[3]+=qnt;
						break;
			}
		}while(ch!=5);
		System.out.println("~~~~~~~~~~~~~~~~~~~~Bill~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("------------------------------------------------");
		for (int i=0;i<4;i++) {
		if(cont[i]!=0) {
			System.out.println(item[i]+"\t"+cont[i]+" Nos\t\tRs "+cont[i]*pri[i]);
			qnti+=cont[i];
		}
		}
		System.out.println("------------------------------------------------");
		System.out.println("Total:\t\t"+qnti+" Nos\t\tRs "+amt);
		System.out.println("\n~~~~~~~~~~~~~~~~~Thank You~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~Visit Again~~~~~~~~~~~~~~~~~~~~~~");
		
		sc.close();
	}
}
