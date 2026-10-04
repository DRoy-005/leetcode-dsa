class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int count = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            int currentFreq = map.get(num);
            if(currentFreq > maxFreq){
                maxFreq = currentFreq;
            }
        }
        for(int value : map.values()){
            if(value == maxFreq){
                count += value;
            }
        }
        return count;
    }
}