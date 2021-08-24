package com.app.tester;

import com.app.core.Box;
import java.util.Scanner;

class TestBox {
    public static void main(String[] args) {
        int data;
        // sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter BOx dims : w d h");
        Box b1;// ref type of var : class type of ref
        // System.out.println(b1);
        // (implies that it can refer ONLY to BOx type of objs)
        // no objects are created. : method local var : STACK
        // how many bytes : as per JVM specs
        // System.out.println(b1);
        b1 = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(b1);// F.Q class Name @ hashCode (adr)
        System.out.println(b1.getBoxDetails());
        System.out.println("Box volume " + b1.getBoxVolume());
        Box b2 = b1;// copy of refs
        System.out.println(b2);// same adr
        System.out.println(b2.getBoxDetails());// same o/p as earlier
        b1 = null;// no obj yet marked for GC
        // System.out.println("Box volume " + b1.getBoxVolume());// NPE
        System.out.println(b2.getBoxDetails());// o/p
        b2 = null;// 1 obj marked for GC
        b1 = new Box(3, 5, 6);
        System.out.println(b1);// different
        System.out.println(b1.getBoxDetails());
        // close

        sc.close();
    }
}
