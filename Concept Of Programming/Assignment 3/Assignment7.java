import java.util.*;
class Assignment7{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
int a;
System.out.print("Enter a number ");
a=sc.nextInt();
if(a>0){
System.out.println("1");
}
else if(a<0){
System.out.println("-1");
}
else{
System.out.println("0");
}
}
}