class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Already present in answer
            if (used[ch - 'a'])
                continue;

            // Remove larger characters if they appear again later
            while (!stack.isEmpty()
                    && stack.peekLast() > ch
                    && last[stack.peekLast() - 'a'] > i) {

                used[stack.removeLast() - 'a'] = false;
            }

            stack.addLast(ch);
            used[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }

        return ans.toString();
    }
}