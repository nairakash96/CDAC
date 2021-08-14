package stack;

public class GrowableStack implements Stack {
	private Emp[] empArr;
	private int top=-1;
	public GrowableStack() {
		empArr=new Emp[DEFAULT_Size];
	}
	public GrowableStack(int size) {
		empArr=new Emp[size];
	}
	public void push(Emp e) {
		if(top == empArr.length-1 ) {
			Emp temp[]=new Emp[empArr.length*2];
			for(int i=0;i<empArr.length;i++) {
				temp[i]=empArr[i];
			}
			empArr=temp;
		}
		empArr[++top] = e;
	}
	public Emp pop() {
		if(top == -1) {
			System.out.println("Stack is empty.");
			return null;
		}
		return empArr[top--];
	}



}
