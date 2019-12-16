class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder og = new StringBuilder();
        s = s.toLowerCase();
        for(char c : s.toCharArray()){
            if((c >= 'a' && c<='z') || (c >= '0' && c<='9')){
                og.append(c);
            }
        }
        String formatted = og.toString();
        String reversed = og.reverse().toString();
        return formatted.equals(reversed);
    }
}
