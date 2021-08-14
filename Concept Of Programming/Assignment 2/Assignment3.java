import java.util.*;
class Assignment3{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Principal ammount ");
int p=sc.nextInt();
System.out.print("Enter  Rate ");
float r=sc.nextFloat();
System.out.print("Enter  Period/Time ");
int t=sc.nextInt();
float Si=(p*r*t)/100;
System.out.println("Intrest ="+Si);
System.out.print("Total ammount "+ (Si+p));
}
}