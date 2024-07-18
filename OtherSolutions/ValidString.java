package assesmentsolutions;
import java.util.Stack;
public class ValidString {
	public static boolean isValid(String s) {
		
		Stack<Character> stack=new Stack<>();
		
		for(char c:s.toCharArray()) {
			if(c=='('||c=='['||c=='{') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				
				char ch=stack.pop();
				if((c==')'&&ch=='(')||(c==']'&&ch=='[')||(c=='}'&&ch=='{'))
				continue;
				else
					return false;
			}
		}
		return stack.isEmpty();
		
	}
	public static void main(String[] args) {
		System.out.println("(({})) => " + isValid("(({}))"));
		System.out.println("({)) => " +isValid("({))"));
		
}

}
