package stack;

public class Emp {
	private int empid;
	private String ename;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return ename;
	}
	public void setName(String ename) {
		this.ename = ename;
	}
	public Emp(int empid, String ename) {
		super();
		this.empid = empid;
		this.ename = ename;
	}
	public String toString() {
		return "Emp [empId "+empid+" EmpName= "+ename+" ]";
	}
	
}
