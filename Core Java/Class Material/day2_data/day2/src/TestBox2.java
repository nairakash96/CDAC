import java.util.Scanner;


class TestBox2 {
    public static void main(String[] args) {
        // sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side of a cube");
        Box cube1 = new Box(sc.nextDouble());
        System.out.println(cube1.getBoxDetails());
        System.out.println(cube1.getBoxVolume());
        // close
        Box dummyBox=new Box();
        sc.close();
    }
}
