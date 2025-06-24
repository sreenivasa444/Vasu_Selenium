package testNGMainframe;

public class MainFrame {


	    public static int add(int a, int b) {
	        return a + b;
	    }

	    public static int subtract(int a, int b) {
	        return a - b;
	    }

	    public static void main(String[] args) {
	        // Call your methods and perform testing
	        int a = 5;
	        int b = 10;

	        // Test addition
	        int sum = add(a, b);
	        System.out.println("Sum: " + sum);
	        if (sum == 15) {
	            System.out.println("Addition test passed");
	        } else {
	            System.out.println("Addition test failed");
	        }

	        // Test subtraction
	        int difference = subtract(a, b);
	        System.out.println("Difference: " + difference);
	        if (difference == -5) {
	            System.out.println("Subtraction test passed");
	        } else {
	            System.out.println("Subtraction test failed");
	        }

	        // More testing...

	        // Additional code for your application's main logic
	        // ...
	    }
	}


