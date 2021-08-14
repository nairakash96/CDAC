package tester;

import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean exit = false;
		do {
			System.out.println("Enter your choice \n1. Push\n2. Pop\n 3.Display all\n4.Exit");
			switch (sc.nextInt()) {
			case 1:

				break;
			case 2:

				break;

			case 3:

				break;

			case 4:
				exit = true;

				break;

			default:
				break;
			}
		} while (exit);
		sc.close();
	}

}
