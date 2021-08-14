/*Create a class Emp with fields like empId, name,dept,salary,address.
Write required constructors for initialization
Write a method displayEmpDetails() in the same class.
  
Write another test class , where you have to take emp details from user using Scanner and create object and call methods.
*/
class Emp{
int eid;
String name;
String dept;
long sal;
String addr;
Emp (int eid, String name, String dept, long sal, String addr){
this.eid=eid;
this.name=name;
this.dept=dept;
this.sal=sal;
this.addr=addr;
}
void displayEmpDetails(){
System.out.println("ID= "+eid+"\nName= "+name+"\nDept= "+dept+"\nSalary= "+sal+"\nAddress ="+addr);
}
public static void main(String args[]){
Emp e1=new Emp(1,"Akash","R&D",50000,"Kerele");
e1.displayEmpDetails();
}
}