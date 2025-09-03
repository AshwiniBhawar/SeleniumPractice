package seleniumAssignments;

public class StringConcept {
	
	public static void main(String[] args) {
		String str1="abc";
		String str2="abc ";
		
		if(str1.contains(str2)) {
			System.out.println("match");
		}
		else {
			System.out.println("no match");
		}
	}

}
