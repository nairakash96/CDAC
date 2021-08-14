package p1;

public class OddPrinterRunnable implements Runnable{
	//states:
			private int start;
			private int end;
		
			//Constructor:
			public OddPrinterRunnable(int s,int e) {
				this.start=s;
				this.end=e;
			}
		
		@Override
		public void run()
		{
			System.out.println("Odd Thread Started..");
			try {
			for(int i=start;i<=end;i++)
			{
				if(i%2!=0)
					System.out.println("In odd thread --->" + Thread.currentThread().getName() + " exec # " + i);	
					Thread.sleep(500);
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Odd Thread ends..");
		}

}