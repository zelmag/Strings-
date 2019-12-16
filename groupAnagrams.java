class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] sortedArray = s.toCharArray();
            Arrays.sort(sortedArray);
            String sorted = new String(sortedArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            map.get(sorted).add(s);
        }
        res.addAll(map.values());
        return res; 
    }
}
