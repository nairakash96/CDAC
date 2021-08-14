import java.util.*;
class Assignment17{
static int fact(int a){
	int f=1;
	for(int i=1;i<=a;i++){
		f*=i;
	}
return f;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int temp=n;
int num=0;
while(n>0){
int m=n%10;
num+=fact(m);
n=n/10;
}
if(temp==num){
System.out.println("Its a Strong No");
}
else{
System.out.println("Its not a Strong No");
}
}
}