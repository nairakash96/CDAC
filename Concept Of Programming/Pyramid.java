public class Pyramid {

	public static void main(String[] args) {
		
		for(int i=1;i<7;i++) {
			for(int j=7;j>7-i;j--) {
				System.out.println(j+" ");
			}
			System.out.println();
		}
	}

}
