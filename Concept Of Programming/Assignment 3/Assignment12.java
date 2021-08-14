import java.util.*;
class Assignment12{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
System.out.print("Enter Temperature : ");
int temp=sc.nextInt();
if (temp<0){
System.out.println("Freezing weather");
}
else if (temp>=0&&temp<10){
System.out.println("Very Cold Weather");
}
else if (temp>=10&&temp<20){
System.out.println("Cold Weather");
}
else if (temp>=20&&temp<30){
System.out.println("Normal Temperature");
}
else if (temp>=30&&temp<40){
System.out.println("Its Hot");
}
else{
System.out.println("Its Very Hot");
}
}
}