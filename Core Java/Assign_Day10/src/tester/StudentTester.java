package tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.core.Student;

import custom_exception.StudentException;

import static utils.Validation.*;
import static com.app.core.Student.sdf;

public class StudentTester {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			ArrayList<Student> arrList=new ArrayList<>();
			System.out.println("AL contents");
			for(Student s:arrList)
				System.out.println(s);
			boolean exit=false;
			while(!exit) {
					System.out.println("Option\n1. Add Student\n2. Fetch Student\n3. Display all\n4. Cancel Admission\n5. Update GPA\n6. Exit");
					try {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("Enter Student Details: prn, name, email, password, GPA, course,  DOB");
							arrList.add(new Student(checkForDuplication(sc.next(), arrList),sc.next(),sc.next(),sc.next(),sc.nextDouble(),ValidateType(sc.next()),sdf.parse(sc.next())));
							System.out.println("Student Admitted to course");
							break;
						case 2:
							System.out.println("Enter prn");
							Student a=new Student(sc.next());
							int ind=arrList.indexOf(a);
							if(ind!=-1) {
								Student s=arrList.get(ind);
								System.out.println(s);	
							}
							else {
								throw new StudentException("Invalid PRN");
							}
							break;
						case 3:
							System.out.println("Student Details");
							for(Student s:arrList)
								System.out.println(s);
							
							break;
						case 4:
							System.out.println("Enter prn");
							Student b=new Student(sc.next());
							int i=arrList.indexOf(b);
							if(i!=-1) {
								Student s=arrList.remove(i);
								System.out.println(s+"\nRemoved Student");	
							}
							else {
								throw new StudentException("Invalid PRN");
							}
							break;
						case 5:
							System.out.println("Enter prn");
							Student c=new Student(sc.next());
							int in=arrList.indexOf(c);
							if(in!=-1) {								
								System.out.println("Enter GPA");
								Student s=arrList.get(in);
								s.setGPA(sc.nextDouble());
								System.out.println("GPA Updated ");	
							}
							else {
								throw new StudentException("Invalid PRN");
							}
							break;
						case 6:
							exit=true;
							break;
						default:
							System.out.println("Invalid Input");
							break;
						}
					}catch(Exception e) {
						System.out.println(e);
					}
					sc.nextLine();
			}
		}
	}
}
