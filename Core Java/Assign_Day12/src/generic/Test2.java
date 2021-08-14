package generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Test2 {

	public static void main(String[] args) {
		display(new HashSet<>(Arrays.asList(1,2,6,7,9,0)));
		System.out.println();
		display(new LinkedList<>(Arrays.asList("a1","a2","a3","a4")));
		System.out.println( );
		display2(new HashSet<>(Arrays.asList(1,2,6,7,9,0)));
		System.out.println();
		display2(new LinkedList<>(Arrays.asList("a1","a2","a3","a4")));
	}
	
	public static <T>void display(Collection<T>collection){
		for(T t:collection)
			System.out.print(t+" ");
	}
public static void display2(Collection<?>collection) {
	Iterator<?>itr=collection.iterator();
	while(itr.hasNext()) {
		System.out.print(itr.next()+" ");
	}
}
}
