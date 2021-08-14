import java.util.*;
class Assignment8{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Roll No ");
int rn=sc.nextInt();
sc.nextLine();
System.out.print("Enter Name ");
String name=sc.nextLine();
System.out.println("Enter Marks of Subject ");
System.out.print("Enter Marks of Physic ");
int py=sc.nextInt();
System.out.print("Enter Marks of Maths ");
int mt=sc.nextInt();
System.out.print("Enter Marks of English ");
int en=sc.nextInt();
System.out.println();
System.out.println("Roll No : "+rn);
System.out.println("Name :  "+name);
System.out.println("Marks of Subject ");
System.out.println("Physic : "+py);
System.out.println("Maths : "+mt);
System.out.println("English : "+en);
int tl=py+mt+en;
float per =tl/3.0f;
System.out.println("Total : "+tl);
System.out.println("Percentage : "+per);
}
}