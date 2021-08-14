import java.util.*;
class Assignment1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double sm=0;
            if(sc.hasNextDouble()){
                double a=sc.nextDouble();
                sm+=a;
            }
            else{
                System.out.println("First Value is not double");
            }
            if(sc.hasNextDouble()){
                double b=sc.nextDouble();
                sm+=b;
            }
            else{
                System.out.println("Second Value is not double");
            }
        
        
        System.out.println("Avarage="+sm/2);
        sc.close();
    }
}