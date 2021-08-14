import java.util.*;
class Assignment2 {
public static void main(String[] args) {
    int qnt=0,amt=0,ch,qunti=0;
    int count[]=new int[10];
    Scanner sc=new Scanner(System.in);
    String item[]={"Tea     ","Coffee       ","Sandwitch","Iddli       ","Dosa        ","Icecream","Green Tea","Rice Plate","Vada Pav"};
    int price[]={10,20,50,30,30,25,15,70,15};
    do{
    System.out.println("Welcome to India Foodies");
    System.out.println("1.Tea\n2.Coffe\n3.Sndwitch\n4.Iddli\n5.Dosa\n6.Icecream\n7.Green Tea\n8.Rice Plate\n9.Vada Pav\n10.Exit");
    System.out.println("Enter your choise");
    ch=sc.nextInt();
    switch(ch){
        case 1:System.out.println("You have ordered -->"+item[0]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[0];
                count[0]+=qnt;
                break;
        case 2:System.out.println("You have ordered -->"+item[1]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[1];
                count[1]+=qnt;
                break;
        case 3:System.out.println("You have ordered -->"+item[2]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[2];
                count[2]+=qnt;
                break;
        case 4:System.out.println("You have ordered -->"+item[3]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[3];
                count[3]+=qnt;
                break;
        case 5:System.out.println("You have ordered -->"+item[4]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[4];
                count[4]+=qnt;
                break;
        case 6:System.out.println("You have ordered -->"+item[5]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[5];
                count[5]+=qnt;
                break;
        case 7:System.out.println("You have ordered -->"+item[6]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[6];
                count[6]+=qnt;
                break;
        case 8:System.out.println("You have ordered -->"+item[7]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[7];
                count[7]+=qnt;
                break;
        case 9:System.out.println("You have ordered -->"+item[8]+"\nEnter quantity :");
                qnt=sc.nextInt();
                amt+=qnt*price[8];
                count[8]+=qnt;
                break;
        case 10:System.out.println("~~~~~~~~~~~~~~~~~~~~Bill~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
     }
    }while(ch!=10);
		System.out.println("------------------------------------------------");
		for (int i=0;i<10;i++) {
		if(count[i]!=0) {
			System.out.println(item[i]+"\t"+count[i]+" Nos\t\tRs "+count[i]*price[i]);
			qunti+=count[i];
		}
		}
		System.out.println("------------------------------------------------");
		System.out.println("Total:\t\t"+qunti+" Nos\t\tRs "+amt);
		System.out.println("\n~~~~~~~~~~~~~~~~~Thank You~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~Visit Again~~~~~~~~~~~~~~~~~~~~~~");
		
    sc.close();
} 
}   

