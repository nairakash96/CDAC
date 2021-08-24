
/*
Solve : Write java application to accept int(emp id) ,
, emp's first name, last name ,double(salary)  
is permanent :  boolean from Scanner & display the same using printf

*/
import java.util.Scanner;

class TestScanner {
    public static void main(String[] args) {
        // create scanner instance to wrap std in
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emp id ,first name , last name salary permanet status");
        System.out.printf("Emp id %d First Name %s Last Name %s Sal %.2f IsPermanent %b%n", sc.nextInt(), sc.next(),
                sc.next(), sc.nextDouble(), sc.nextBoolean());
        // close scanner : to release the resource
        sc.close();
    }
}
