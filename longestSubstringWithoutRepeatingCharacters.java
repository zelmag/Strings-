//sliding window 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0; 
        }
        HashSet<Character> seen = new HashSet<Character>();
        int start = 0;
        int end = 0;
        int max = 1; 
        while(end < s.length()){
            if(!seen.contains(s.charAt(end))){
                //then add it and update max
                seen.add(s.charAt(end));
                end++;
                max = Math.max(max,seen.size());
            }else{
                seen.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
}
