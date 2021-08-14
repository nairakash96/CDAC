package tester;

import com.geometry.Point2D;
import java.util.Scanner;
class TestPoint {
 public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     Point2D p1=new Point2D(sc.nextInt(),sc.nextInt());
     Point2D p2=new Point2D(sc.nextInt(),sc.nextInt());
     System.out.println("Point 1 Details "+p1.getDetails());
     System.out.println("Point 2 Details "+p2.getDetails());
     System.out.println(p1.isEqual(p2)?"YES":"NO");
     System.out.println("Distance between two points "+p1.calculateDistance(p2));
     

     sc.close();
 }   
}

