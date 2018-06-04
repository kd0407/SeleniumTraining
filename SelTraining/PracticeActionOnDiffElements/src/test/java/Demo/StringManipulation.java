package Demo;

import org.testng.annotations.Test;

public class StringManipulation {
	@Test
	public void getString() {
	
	String strTest = "  Showing 1 to 10 of 31 entries  ";
	String strTest1 = "Showing 1 to 10 of 31 entries";
	System.out.println(strTest.length());
	System.out.println();
	System.out.println(strTest.substring(9));
	System.out.println(strTest.charAt(10));
	System.out.println(strTest.substring(21, 24));
	System.out.println(strTest.trim());
	//System.out.println(strTest.replaceFirst(regex, replacement));
	String[] aEntriesText = strTest1.split(" ");
	System.out.println(aEntriesText.length-2);
	//array at index
	String textAt = aEntriesText[aEntriesText.length-2];
	System.out.println(textAt);
	
	String str_Sample = "RockStar";
	System.out.println("Replace 'Rock' with 'Duke': " + str_Sample.replace("Rock", "Duke"));
	
	
	
	}
}
