package zigzagConversion;

public class Solution {
	public String convert(String s, int numRows) {
		if(numRows==1)	return s;
		
		StringBuilder sb = new StringBuilder();
		int gap = numRows + (numRows - 2);
		
		for(int line = 0; line<numRows; line++) {
			for(int element = 0; element<s.length(); element+=gap) {
				if(element+line<s.length()) {
					sb.append(s.charAt(element+line));
				}
				if(line!=0 && line!=numRows-1 && (element+gap-line)<s.length()) {
					sb.append(s.charAt(element+gap-line));
				}
			}
		}
		
		return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int numRows = 1;
		String result = new Solution().convert(s, numRows);
		System.out.println(result);
		System.out.println(result.equals("PAYPALISHIRING"));
	}

}
