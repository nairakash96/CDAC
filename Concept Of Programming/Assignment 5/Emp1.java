/*Create a class Emp with fields like empId, name,dept,salary,address.
Write required constructors for initialization
Write a method displayEmpDetails() in the same class.
  
Write another test class , where you have to take emp details from user using Scanner and create object and call methods.
*/
import java.util.*;
class Emp1{
		Scanner sc =new Scanner(System.in);
		int eid;
		String name;
		String dept;
		long sal;
		String addr;

	void setEmp(){
		System.out.print("Enter Employee Id ");
		this.eid=sc.nextInt();

		System.out.print("Enter Employee name ");
		this.name=sc.next();
		System.out.print("Enter Employee Dept ");
		this.dept=sc.next();
		System.out.print("Enter Employee Salary ");
		this.sal=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Employee Address ");
		this.addr=sc.nextLine();
	}

	void displayEmpDetails(){
		System.out.println("\nEmployee Details are :");
		System.out.println("Employee ID= "+eid+"\nEmployee Name= "+name+"\nEmployee Dept= "+dept+"\nEmployee Salary= "+sal+"\nEmployee Address ="+addr);
	}
	public static void main(String args[]){
		Emp1 e1=new Emp1();
		e1.setEmp();
		e1.displayEmpDetails();
	}
}