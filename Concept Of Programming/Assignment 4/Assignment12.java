import java.util.*;
class Assignment12{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int temp=n;
int num=0;
while(n>0){
int m=n%10;
num+=Math.pow(m,3);
n=n/10;
}
if(temp==num){
System.out.println("Its a Armstrong number");
}
else{
System.out.println("Not a Armstrong number");
}
}
}