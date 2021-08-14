package generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<String>list1=Arrays.asList("one","two","three","four","five");
		Collections.shuffle(list1);
		System.out.println(list1);
		List<Double> dob=Arrays.asList(1.0,2.6,3.5,4.4,9.9,8.2,3.3,4.5,6.9,7.5);
		Collections.shuffle(dob);
		System.out.println(dob);
	}

}
