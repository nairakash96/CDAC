import java.util.*;
class Assignment15{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int num=0;
System.out.println("The Number is "+n);
while(n>0){
int m=n%10;
num*=10;
num+=m;
n=n/10;
}
System.out.println("The Number is "+num);
}
}