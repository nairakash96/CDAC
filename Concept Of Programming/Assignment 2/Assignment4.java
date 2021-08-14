import java.util.*;
class Assignment4{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Basic Salary ");
int s=sc.nextInt();
float hra=s*.40f;
float pf=s*.12f;
int ma=1200;
int ta=800;
int tax=300;
double sal=s+hra+ma+ta-pf-tax;
System.out.println("In Hand Salary ="+sal);
}
}