import java.util.*;
class Assignment14{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int f=0;
int s=1;
int nxt;
for(int i=0;i<n;i++){
	System.out.print(f+" ");
	nxt=f+s;
	f=s;
	s=nxt;
}
}
}