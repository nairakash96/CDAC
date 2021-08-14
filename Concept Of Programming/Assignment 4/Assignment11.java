import java.util.*;
class Assignment11{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int num=0;
for(int i=1;i<n;i++){
	if(n%i==0){
		num+=i;
	}
}
if(n==num){
System.out.println("Its a perfect No");
}
else{
System.out.println("Not a Perfect No");
}
}
}