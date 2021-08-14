package p1;

public class EvenPrinterRunnable implements Runnable{
		//states:
		private int start;
		private int end;
	
		//Constructor:
		public EvenPrinterRunnable(int s,int e) {
			this.start=s;
			this.end=e;
		}
	
	@Override
	public void run()
	{
		System.out.println("Even Thread Started..");
		try {
		for(int i=start;i<=end;i++)
		{
			if(i%2==0)
				System.out.println("In Even Thread --->" + Thread.currentThread().getName() + " exec # " + i);	
				Thread.sleep(500);
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Even Thread ends..");
	}
}