package p1;

public class Tester {

	public static void main(String[] args) {

			try {
				System.out.println(Thread.currentThread().getName()); //main(thr name) 5(priority) main(thrd group)
				
				//create an instance of runnable task
				EvenPrinterRunnable even=new EvenPrinterRunnable(1,50);//Runnable : 1(main) ,(New:1)
				//attach thread to the runnable class instance : Thread(Runnable Task,String Name)
				Thread  t1=new Thread(even,"Even Thread");
				
				OddPrinterRunnable odd=new OddPrinterRunnable(1,50);//Runnable : 1(main) ,(New:2)
				Thread  t2=new Thread(odd,"Odd Thread");

				t1.start();
				t2.start();
				//Runnable : 1+2(3)
				
        		Thread.sleep(100);// Blocked : on sleep
        		System.out.println("Main Thread is waiting..");
        		System.out.println("t1 is alive : "+t1.isAlive()+"\nt2 is alive :"+t2.isAlive()); //true ,true
				t1.join();
				t2.join();
        		System.out.println("t1 is alive : "+t1.isAlive()+"\nt2 is alive :"+t2.isAlive()); //false , false
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Main Over..");
	}

}