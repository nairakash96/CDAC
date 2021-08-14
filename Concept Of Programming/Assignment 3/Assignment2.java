import java.util.*;
class Assignment2{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
int a,b;
System.out.print("Enter value of A ");
a=sc.nextInt();
System.out.print("Enter value of B ");
b=sc.nextInt();
System.out.println("Before Swap");
System.out.println("A= "+a+" B = "+b);
a=a+b;
b=a-b;
a=a-b;
System.out.println("After Swap");
System.out.println("A= "+a+" B = "+b);
}
}