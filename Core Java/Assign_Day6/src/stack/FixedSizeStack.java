package stack;

public class FixedSizeStack  implements Stack{

	private Emp[] empArr;
	private int top=-1;
	public FixedSizeStack() {
		empArr=new Emp[DEFAULT_Size];
	}
	public FixedSizeStack(int size) {
		empArr=new Emp[size];
	}
	public void push(Emp e) {
		if(top == empArr.length-1 ) {
			System.out.println("Stack is full!");
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
