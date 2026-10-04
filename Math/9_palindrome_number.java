class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int val = 0;
        if( x < 0){
            return false;
        }
        while(x != 0){
            int rem = x%10;
            val = (val * 10) + rem;
            x = x/ 10;
        }

        if(val == temp){
            return true;
        }
        else{
            return false;
        }
    }
}