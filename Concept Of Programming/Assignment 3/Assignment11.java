import java.util.*;
class Assignment11{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
System.out.print("Enter Roll No : ");
int rn=sc.nextInt();
System.out.print("Enter Name : ");
String name=sc.next();
System.out.println("Enter Marks of Subject : ");
System.out.print("Enter marks of Physic : ");
int py=sc.nextInt();
System.out.print("Enter marks of Chemistry : ");
int ch=sc.nextInt();
System.out.print("Enter marks of Computer Applicatin : ");
int ca=sc.nextInt();
System.out.println();
System.out.println("Roll No : "+rn);
System.out.println("Name : "+name);
System.out.println("Marks of Subject: ");
System.out.println("Marks of Physic : "+py);
System.out.println("Marks of Chemistry : "+ch);
System.out.println("Marks of Computer Applicatin : "+ca);
int tl=py+ch+ca;
System.out.println("Total = "+tl);
float per=tl/3.0f;
System.out.println("Percentage = "+per);
if (per>=75){
System.out.println("Division: First class");
}
else if (per>=65&&per<75){
System.out.println("Division : Second class");
}
else{
System.out.println("Pass Class");
}
}
}