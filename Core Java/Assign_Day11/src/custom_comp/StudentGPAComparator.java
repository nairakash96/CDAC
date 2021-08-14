package custom_comp;
import java.util.Comparator;

import com.app.core.Student;
public class StudentGPAComparator implements Comparator<Student>{
public int compare(Student a1,Student a2) {
	
//	System.out.println("in compare : date");
	if(a1.getGPA()>(a2.getGPA()))
		return -1;
	if(a1.getGPA()<(a2.getGPA()))
		return 1;
	return 0;
	
}
}
