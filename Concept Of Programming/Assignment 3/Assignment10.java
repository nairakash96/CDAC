import java.util.*;
class Assignment10{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
int a[] =new int[5];
for(int i=0;i<5;i++){
a[0]=sc.nextInt();
}
int min =a[0];
for(int i=0;i<5;i++){
	if(min<a[i]){
		min=a[i];
	}
}
System.out.println(min+" is smallest no");
}
}