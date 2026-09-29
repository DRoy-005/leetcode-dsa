class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] frequency  = new int[26];
        int maxFrequency = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            int windowLength = right - left + 1;
            int freq = ++frequency[s.charAt(right) - 'A'];
            maxFrequency = Math.max(maxFrequency, freq);
            while((windowLength - maxFrequency) > k){
                windowLength--;
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, windowLength);
        }
        return maxLength;
    }
}