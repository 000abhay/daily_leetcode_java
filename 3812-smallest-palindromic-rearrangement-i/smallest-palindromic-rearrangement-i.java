class Solution {
    public String smallestPalindrome(String s) {
         int n = s.length();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        char[] ans = new char[n];
        int left = 0;
        int right = n - 1;

        if (n % 2 == 0) {
            for (int i = 0; i < n; i += 2) {
                ans[left++] = ch[i];
                ans[right--] = ch[i + 1];
            }
        } else {
            // Find the odd-frequency character
            char odd = 0;
            for (char c : ch) odd ^= c;

            ans[n / 2] = odd;

            boolean skipped = false;

            for (int i = 0; i < n; ) {
                // Skip the single odd character once
                if (!skipped && ch[i] == odd && (i == n - 1 || ch[i] != ch[i + 1])) {
                    skipped = true;
                    i++;
                    continue;
                }

                ans[left++] = ch[i];
                ans[right--] = ch[i + 1];
                i += 2;
            }
        }

        return new String(ans);
    }
}