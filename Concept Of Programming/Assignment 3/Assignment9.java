import java.util.*;
class Assignment9{
public static void main(String args[]){
Scanner sc= new Scanner(System.in);
int a,b,c;
System.out.print("Enter three number ");
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
if(a>b){
	if(a>c){
		System.out.println(a+" is Largest no");
	}
	else{
		System.out.println(c+" is Largest no");
	}
}else
{
	if(b>c){
		System.out.println(b+" is Largest no");
	}
	else{
		System.out.println(c+" is Largest no");
	}
}
}
}