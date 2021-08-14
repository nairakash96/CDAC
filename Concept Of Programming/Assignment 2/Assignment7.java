import java.util.*;
class Assignment7{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Principle ");
int p=sc.nextInt();
System.out.print("Enter  Rate ");
float r=sc.nextFloat();
System.out.print("Enter compounding Period ");
int n=sc.nextInt();
System.out.print("Enter  Period/Time ");
int t=sc.nextInt();
double CI=p*Math.pow((1+(r/n)*.01f),t*n);
System.out.println("Total Amount ="+CI);
System.out.println("Compound Intrest ="+(CI-p));
}
}