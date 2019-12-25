class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            if(!seen.contains(s.charAt(right))){
                //haven't seen this char before. add it. 
                seen.add(s.charAt(right));
                max = Math.max(max,right-left+1);
                right++;
            }else{
                //have seen it before. time to pop characters off until have one that is unique. 
                while(seen.contains(s.charAt(right))){
                    //keep popping off
                    seen.remove(s.charAt(left++));
                }
            }
        }
        return max;
    }
}
