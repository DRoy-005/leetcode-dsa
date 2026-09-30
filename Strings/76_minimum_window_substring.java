class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int left = 0;
        int minLength = s.length() + 1;
        int[] freq = new int[128];
        int[] window = new int[128];
        int requiredCharCount = 0;
        int satisfiedCharCount = 0;

        for(int right = 0; right < t.length(); right++){
            int index = t.charAt(right);
            if(freq[index] == 0){
                requiredCharCount++;
            }
            freq[index]++;
        }

        for(int right = 0; right < s.length(); right++){
            int index = s.charAt(right);
            window[index]++;
            
            if(window[index] == freq[index]){
                satisfiedCharCount++; 
            }

            while(satisfiedCharCount == requiredCharCount){
                int currWindowLength = right - left + 1;
                if(currWindowLength < minLength){
                    minLength = currWindowLength;
                    start = left;
                }
                int leftIdx = s.charAt(left);
                window[leftIdx]--;

                if(window[leftIdx] < freq[leftIdx]){
                    satisfiedCharCount--;
                }
                left++;
            }
        }

        if(minLength == s.length() + 1){
            return "";
        }
        return s.substring(start, start + minLength);
    }
}