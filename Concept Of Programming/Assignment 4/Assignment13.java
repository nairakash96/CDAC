import java.util.*;
class Assignment13{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int prime=1;
for(int i=2;i<n;i++){
	if(n%i==0){
		prime=0;
	}
}
if(prime==1||n==2){
System.out.println("Its a Prime number");
}
else{
System.out.println("Not a Prime number");
}
}
}