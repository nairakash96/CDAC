package com.app.test;

import java.util.Scanner;

import com.app.org.Emp;
import com.app.org.Mng;
import com.app.org.Worker;

public class TestOrg {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vacency");
		Emp[] emp=new Emp[sc.nextInt()];
		boolean exit=false;
		int counter=0;
		while(!exit) {
			System.out.println("Enter your choice\n1. Hire Manager\n2. Hire Worker\n3. Display\n4. Update\n5. Exit ");
			switch (sc.nextInt()) {
			case 1:if(counter<emp.length) {
						System.out.println("Enter details id,name,basic,Dept,perfmonceBonus");
						emp[counter++]=new Mng(sc.nextInt(),sc.next(),sc.nextDouble(),sc.next(),sc.nextDouble());
					}
					else {
						System.out.println("No Vacency");
					}
				break;
				
			case 2:if(counter<emp.length) {
						System.out.println("Enter details id, name, basic, Dept ,hoursWorked, hourlyRate");
						emp[counter++]=new Worker(sc.nextInt(),sc.next(),sc.nextDouble(),sc.next(),sc.nextDouble(),sc.nextDouble());
					}
					else {
						System.out.println("No Vacency");
					}
				break;
				
			case 3:for(Emp e:emp) {
						if(e!=null) {
							System.out.println(e);
						}
					}
					break;
					
			case 4:System.out.println("Enter eid bonous hourly rate");
			 		int id=sc.nextInt();
			 		double inc=sc.nextDouble();
			 		for(Emp e:emp) {
			 			if(e != null)
			 				  if (e.getId() == id)
			 				     if(e instanceof Mng)
			 				      ((Mng) e).setPerfmonceBonus(((Mng) e).getPerfmonceBonus()+inc);
			 				     else //it's a worker
			 				      ((Worker)e).setHourlyRate(((Worker)e).getHourlyRate()+inc);
			 				  }
			 				break;
					
			case 5:exit=true;
					break;

			}
		}
		sc.close();
	}

}
