package leet_hw1;

/**
 * 20. Valid Parentheses Add to List DescriptionHintsSubmissionsSolutions Total
 * Accepted: 196761 Total Submissions: 595619 Difficulty: Easy Given a string
 * containing just the characters '(', ')', '{', '}', '[' and ']', determine if
 * the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author liyugong
 *
 */
public class hw2_validParentheses {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		//use stack
		ArrayList<Character> expect = new ArrayList<Character>();
		expect.add('a');
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				expect.add(')');
			else if (s.charAt(i) == '[')
				expect.add(']');
			else if (s.charAt(i) == '{')
				expect.add('}');
			else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
				if (expect.get(expect.size() - 1) != s.charAt(i))
					return false;
				else
					expect.remove(expect.size() - 1);
			}
		}
		if (expect.size() != 1)
			return false;
		return true;
	}
}
