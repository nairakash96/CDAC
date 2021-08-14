import java.util.*;
class Assignment6{
public static void main(String args[]){
Scanner sc =new Scanner(System.in);
System.out.print("Enter  Radius ");
int r=sc.nextInt();
double area=Math.PI*r*r;
double peri =2*Math.PI*r;
System.out.println("Area ="+area);
System.out.println("Perimeter ="+peri);
}
}