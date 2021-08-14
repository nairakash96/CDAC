import java.util.*;
class Assignment2{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int sm=0;
int a[]=new int[10];
for(int i=0;i<10;i++){
a[i]=sc.nextInt();
sm+=a[i];
}
float avg=sm/10.f;
System.out.print("\nSum ="+sm);
System.out.print("\nAvg ="+avg);

}
}