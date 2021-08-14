import java.util.*;
class Assignment5{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Length ");
int l=sc.nextInt();
System.out.print("Enter  Breath ");
int b=sc.nextInt();
long area=l*b;
long peri =2*(l+b);
System.out.println("Area ="+area);
System.out.println("Perimeter ="+peri);
}
}