package tester;


import static utils.ValidateCustomer.*;

import java.util.Scanner;

import com.app.core.Customer;

public class TestCustmer {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter capacity");
			Customer[] customer = new Customer[sc.nextInt()];
			boolean exit = false;
			int counter = 0;
			while (!exit) {
				System.out.println("Options 1. Add a Customer 2. Display All 3.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer details : name,email,password,registrationAmount,DOB,costomerType");
						Customer c=new Customer(sc.next(),ValidateEmail(sc.next()),ValidatePassword(sc.next()),ValideRegAmount(sc.nextDouble()),
								ValidateDOB(sc.next()),ValidateCustType(sc.next()));
						customer[counter++]=c;
						System.out.println("Customer added....");
						break;
					case 2:
						System.out.println("All Customer details");
						for(Customer v1 : customer)
							if(v1 != null )
								System.out.println(v1);

						break;
					case 3:
						exit = true;

						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//to clear buffer of scanner till new line
				sc.nextLine();

			}
		}

	}

}
