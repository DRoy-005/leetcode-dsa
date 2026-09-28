class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int answer = nums[0];

        for(int i = 1; i < nums.length; i++){
            int current = nums[i];
            int tempMax = maxEndingHere;
            int tempMin = minEndingHere;

            maxEndingHere = Math.max(current, Math.max(tempMax * current, tempMin * current));
            minEndingHere = Math.min(current, Math.min(tempMax * current, tempMin * current));

            answer = Math.max(answer, maxEndingHere);
        }

        return answer;
    }
}