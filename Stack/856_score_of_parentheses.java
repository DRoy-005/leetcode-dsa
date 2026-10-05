class Solution {
    public int scoreOfParentheses(String s) {
         Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {
          
            if (c == '(') {
                st.push(0);
            } else {
                int tmp = st.pop();

                int val = (tmp > 0) ? 2 * tmp : 1;

                st.push(st.pop() + val);
            }
        }
        return st.pop();
    }
}