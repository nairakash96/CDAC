package tester;

import java.util.Scanner;

import com.app.vehicle.Vehicle;

public class Test1 {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)){
			System.out.println("1st vehicle detils");
			Vehicle v1=new Vehicle(sc.next(),sc.next(),sc.nextDouble());
			System.out.println("2nd vehicle detils");
			Vehicle v2=new Vehicle(sc.next(),sc.next(),sc.nextDouble());
			System.out.println(v1==v2);
			System.out.println(v1.equals(v2));
		}
	}

}
