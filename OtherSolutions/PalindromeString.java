package assesmentsolutions;

public class PalindromeString {
	public static boolean isPalindrome(String s) {
		int start=0;
		int end=s.length()-1;
		
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
			return false;
			
			start++;
			end--;
		}
		return true;
				
	}
	public static void main(String[] args) {
		System.out.println("NITIN="+isPalindrome("NITIN"));
		System.out.println("SEJAL="+isPalindrome("SEJAL"));
	}

}
