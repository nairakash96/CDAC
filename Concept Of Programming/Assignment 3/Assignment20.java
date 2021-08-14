import java.util.*;
class Assignment20{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int a[]=new int[5];
for(int i=0;i<5;i++){
a[i]=sc.nextInt();
}
for(int i=0;i<5;i++){
for(int j=0;j<5;j++){
if(a[i]>a[j]){
int temp=a[i];
a[i]=a[j];
a[j]=temp;
}
}
}
for(int i=0;i<5;i++){
System.out.print(a[i]+" ");
}

System.out.println("\nSecond largest "+a[1]);
}
}