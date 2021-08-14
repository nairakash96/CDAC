/*class Example1 {
    // Your program begins with a call to main().
    public static void main(String args[]) {
      System.out.println("This is a simple Java program.");
    }
  }*/


 /* class Example1 {
    public static void main(String args[]) {
      int num; // this declares a variable called num
  
      num = 100; // this assigns num the value 100
  
      System.out.println("This is num: " + num);
  
      num = num * 2;
  
      System.out.print("The value of num * 2 is ");
      System.out.println(num);
    }
  }*/


 /* class Example1 {
    public static void main(String args[]) {
      int x, y;
  
  
      x = 10;
      y = 20;
  
      if(x < y) System.out.println("x is less than y");
      
      x = x * 2;
      if(x == y) System.out.println("x now equal to y");
  
      x = x * 2;
      if(x > y) System.out.println("x now greater than y");
  
      // this won't display anything
      if(x == y) System.out.println("you won't see this");
    }
  }*/

  
  class Example1 {
    public static void main(String args[]) {
      int x, y;
       y = 20;
  
      // the target of this loop is a block
      for(x = 0; x<10; x++) {
        System.out.println("This is x: " + x);
        System.out.println("This is y: " + y);
        y = y - 2;
      }
    }
  }
  
  
  
