class Solution {
    public String minWindow(String s, String t) {
        //need a hashmap for t
        HashMap<Character,Integer> goal = new HashMap<Character,Integer>();
        for(int i = 0; i < t.length(); i++){
            int count = goal.getOrDefault(t.charAt(i),0);
            goal.put(t.charAt(i),count+1);
        }
        // a hashmap for current substring in s
        //loop through hashmap t and make sure its all in s's hashmap 
        int left = 0;
        int right = 0;
        int required = goal.size();
        int formed = 0; //keep track of how many letters with the right frequencies you've checked off
        int[] best = new int[]{0,Integer.MAX_VALUE};
        HashMap<Character,Integer> currMap = new HashMap<Character,Integer>();
        while(right < s.length()){
            char c = s.charAt(right);
            int count = currMap.getOrDefault(c,0);
            currMap.put(c,count+1);
            if(goal.containsKey(c) && currMap.get(c).intValue() == goal.get(c).intValue()){
                formed++;
            }
            //contract until ceases to be enough
            while(left<=right && formed == required){
                //update best
                if(best[1] - best[0] > right - left){
                    best[0] = left; 
                    best[1] = right;
                }
                if(goal.containsKey(s.charAt(left)) 
                   && currMap.get(s.charAt(left)).intValue() == goal.get(s.charAt(left)).intValue()){
                    formed--;
                }
                currMap.put(s.charAt(left),currMap.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }
        return best[1] == Integer.MAX_VALUE ? "" : s.substring(best[0],best[1]+1);
    }
}
