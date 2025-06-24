package Selenium;

import java.util.Iterator;

public class TestDemo {

	public static void main(String[] args) {

		
		
		String str= "", rev ="";
		
		
		for(int i=str.length()-1;i>=0;i--) {
			
			rev=rev+str.charAt(i);			
		}
		System.out.println(rev);
		
		if (str.equals(rev)) {
			System.out.println("Palandrome");
			
		}else {
			System.out.println("Not Palandrome");
		}
		
	}

}
