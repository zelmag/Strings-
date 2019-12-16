//anagram means same letters, same frequencies. just rearranged
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            //if lengths are different, obviously not an anagram
            return false; 
        }
        int[] counter = new int[26];
        for(int i=0; i<s.length(); i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count : counter){
            if(count != 0){
                return false; 
            }
        }
        return true;
    }
}
