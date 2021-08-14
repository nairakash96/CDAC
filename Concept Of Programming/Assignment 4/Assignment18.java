import java.util.*;
class Assignment18{
public static void main(String args[]){
	int i=0;
Scanner sc=new Scanner(System.in);
System.out.print("Enter String :");
String str =sc.next();
str+="\n";
while(str.charAt(i)!='\n'){
i++;
}
System.out.println("String length "+i);
}
}