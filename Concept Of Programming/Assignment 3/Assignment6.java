import java.util.*;
class Assignment6{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
int a;
System.out.print("Enter your age ");
a=sc.nextInt();
if(a>0&&a<18){
System.out.println("You are too young, You can't cast vote");
}
else if(a>=18&&a<100){
System.out.println("You can cast vote  ");
}
else{
System.out.println("Invalid Age");
}
}
}