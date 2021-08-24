public class TestPrimitiveTypes {
    public static void main(String[] args) {
        // byte b1=128;
        byte b1 = 19;
        byte b2 = 12;
        byte b3 = (byte) (b1 + b2);
        b1 += 11;// b1 =(byte) (b1 + 11);
        short s1 = b1;
        int s2 = b1 + s1;
        double d1 = 12.34f;// float--->double (widening conversion)
        float f1 = (float) 12.34;// double ---X---> float
        long l1 = 1235678;
        f1 = l1;// long ---> float(widening)
        int counter = 10;
        if (counter == 10)
            System.out.println("yes...");
        else
            System.out.println("no");
    }
}
