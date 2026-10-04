class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> count = new ArrayDeque<>();
        count.push(-1);
        int max = 0;
        for(int i = 0; i< s.length(); i++){
            if( s.charAt(i) == '('){
                count.push(i);
            }
            else{
                
                count.pop();
                
                if(count.isEmpty()){
                    count.push(i);
                }
                else{
                    int len = i - count.peek(); 
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }
}