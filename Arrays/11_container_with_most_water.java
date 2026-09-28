class Solution {
    public int maxArea(int[] height) {
        int vol = 0; 
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int len = right - left;
            int high = Math.min(height[left], height[right]);
            int area = len * high;

            if(area > vol){
                vol = area;
            }

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return vol;
    }
}