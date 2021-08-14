import java.util.*;
class Assignment16{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
System.out.print("Enter marks of Physic,Chemistry and Maths : ");
int py= sc.nextInt();
int ch= sc.nextInt();
int mt= sc.nextInt();
float avg=(py+ch+mt)/3.0f;
if(avg<30){
System.out.println("Your percentage is "+avg+"\nYou are failed");
}
else if(avg>=30&&avg<60){
System.out.println("Your percentage is "+avg+"\nYou passed with Second division");
}
else if(avg>=60&&avg<80){
System.out.println("Your percentage is "+avg+"\nYou passed with First division");
}
else
{
System.out.println("Your percentage is "+avg+"\nYou passed with First class distinction");
}
}
}