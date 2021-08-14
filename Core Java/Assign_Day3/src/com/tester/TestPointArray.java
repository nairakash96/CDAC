package com.tester;

import java.util.Scanner;
import com.geometry.Point2D;
public class TestPointArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of points");
		Point2D[] point=new Point2D[sc.nextInt()];
		int ch;
		do {
		System.out.println("Enter your choice\n1.Plot point\n2.Display Point\n3.Is Equal\n4.Distance\n5.Exit");
		ch=sc.nextInt();
		switch(ch) {		
		case 1: System.out.println("Enter index");
				int index=sc.nextInt();
				if(index<point.length &&point[index]==null) {
					point[index]=new Point2D(sc.nextInt(),sc.nextInt());
				}
				else {
					System.out.println("point ploting error");
				}
				break;
		case 2:	for(Point2D p:point) {
					System.out.println(p.getDetails());
				}
				break;
		case 3: System.out.println("Enter two index");
				int p1=sc.nextInt();
				int p2=sc.nextInt();
				System.out.println(point[p1].isEqual(point[p2])? "Same":"Not Same");
				break;
		case 4:System.out.println("Enter two index");
				int a1=sc.nextInt();
				int a2=sc.nextInt();
				System.out.println("Distance between point "+a1+" and "+a2+" is "+point[a1].calculateDistance(point[a2]));
				break;
		}
		}while(ch!=5);
		
		sc.close();

}
	
}
