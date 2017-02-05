package arrays;

public class PalindromeNumber {

	public static void main(String[] args) {
		// -2147447412
		// -2147483648
		System.out.println(isPalindrome(-2147447412));
	}

	public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
	}
}
