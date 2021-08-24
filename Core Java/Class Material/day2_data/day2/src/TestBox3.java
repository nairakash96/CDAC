import java.util.Scanner;

class TestBox3 {
    public static void main(String[] args) {
        // sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dims of 1st box");
        Box b1 = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Enter dims of 2nd  box");
        Box b2 = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(b1.checkEqual(b2) ? "SAME" : "DIFFERENT");
        // close

        sc.close();
    }
}
