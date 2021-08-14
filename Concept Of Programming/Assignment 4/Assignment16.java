import java.util.*;
class Assignment16{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int num=0;
int temp =n;
System.out.println("The Number is "+n);
while(n>0){
int m=n%10;
num*=10;
num+=m;
n=n/10;
}
if(temp==num){
System.out.println("It is Palindrom Number");
}
else{
System.out.println("Its not a Palindrom Number");
}
}
}