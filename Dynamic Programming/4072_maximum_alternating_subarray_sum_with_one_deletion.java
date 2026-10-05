class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long inf = 1L << 60;
        
        long even0 = nums[0];
        long odd0 = -inf;
        long even1 = -inf;
        long odd1 = -inf;
        
        long even0_prev = even0;
        long odd0_prev = odd0;
        long even1_prev = even1;
        long odd1_prev = odd1;
        
        long even0_prev2 = -inf;
        long odd0_prev2 = -inf;
        
        long ans = nums[0];
        
        for (int i = 1; i < n; i++) {
            long val = nums[i];
            
            even0 = Math.max(val, odd0_prev + val);
            odd0 = even0_prev - val;
            
            even1 = Math.max(odd1_prev + val, odd0_prev2 + val);
            odd1 = Math.max(even1_prev - val, even0_prev2 - val);
            
            ans = Math.max(ans, even0);
            ans = Math.max(ans, odd0);
            ans = Math.max(ans, even1);
            ans = Math.max(ans, odd1);
            
            even0_prev2 = even0_prev;
            odd0_prev2 = odd0_prev;
            
            even0_prev = even0;
            odd0_prev = odd0;
            even1_prev = even1;
            odd1_prev = odd1;
        }
        
        return ans;
    }
}
