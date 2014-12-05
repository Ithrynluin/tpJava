package pattern.exo1.adaptateur;

public class TestFile {

	public static void main(String[] args) {
		File<Integer> file = new FileImpl<Integer>();
		
		file.insererQueue(Integer.valueOf(1));
		file.insererQueue(Integer.valueOf(2));
		
		file.retirerTete();
		
		System.out.println(file.tete());
	}
	
	//
}
