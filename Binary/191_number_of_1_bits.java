class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while(i < 32){
            int bitMask = 1 << i;
            if((n & bitMask) != 0){
                count++;
            }

            i++;
        }
        return count;
    }
}