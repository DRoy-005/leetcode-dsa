class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i< strs.length; i++){
            String word = strs[i];
            int[] count = new int[26];
            String key = "";

            for(int j = 0; j< word.length(); j++){
                count[word.charAt(j) - 'a']++;
            }
            key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);

        }
        return new ArrayList<>(map.values());
    }
}