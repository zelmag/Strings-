//sliding window problem
class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0; 
        }
        
        int[] freqChar = new int[26]; //keep track of frequency of each character
        int start = 0; //start of window
        int freqMostRepeatedChar = 0;
        int maxFutureSize = 0;
        
        for(int end = 0; end < s.length(); end++){
            freqChar[s.charAt(end) - 'A']++; //increase freq of this character
            freqMostRepeatedChar = Math.max(freqMostRepeatedChar,freqChar[s.charAt(end) - 'A']);
            
            // if max character frequency + distance between start and end is greater than k
            // this means we have considered changing more than k charactres. So time to shrink window
            if(end - start + 1 - freqMostRepeatedChar > k){
                freqChar[s.charAt(start) - 'A']--; //pop off the start of the window 
                start ++;
            }
            maxFutureSize = Math.max(maxFutureSize,end-start+1);
        }
        return maxFutureSize; 
    }
}
