// DRM encryption
/* Assumptions:
*	Input String length is even
*	Input String Length <= 15,000
*	All characters are upper case
*/
import java.util.*;
class C {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
    	String in = scanner.next();
		final String [] inArray = new String[2];
		
		int middle = in.length() / 2;

		char [] left = rotateString( in.substring(0, middle).toCharArray() );
		char [] right = rotateString( in.substring(middle, in.length()).toCharArray() );
		
		String result = merge(left, right);
		System.out.println(result);
		
	}

	public static String merge (char [] left, char [] right) {
		for(int i = 0; i < left.length; i++) {
			
			left[i] = rotateCharacter(left[i], right[i] % 'A');
		}

		return String.valueOf(left);
	}


	public static char[] rotateString (char[] str) {
		int sum = getSum(str);
		
		for(int i = 0; i < str.length; i++) {
			
			str[i] = rotateCharacter(str[i], sum);
		
		}
		
		return str;
	}
	public static char rotateCharacter(char c, int numTimes) {
		int result = ((  c + numTimes - 'A' ) % 26 ) + 'A';
		
		return (char) result;
	}
	public static int getSum(char [] str) {
		int sum = 0;
		
		for(int i : str)
			sum += i % 'A';
		
		return sum;
	}	
}
