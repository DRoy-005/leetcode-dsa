class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i< 32; i++){
            int bitMask = 1 << i;
            if((n & bitMask) != 0){
                result = result | (1 << (31 - i));
            }
        }
        return result;
    }
}
