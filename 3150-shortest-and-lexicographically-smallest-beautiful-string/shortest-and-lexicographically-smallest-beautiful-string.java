class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int low = 0;
        int ones = 0;

        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;

        for (int high = 0; high < n; high++) {

            if (s.charAt(high) == '1') {
                ones++;
            }

            // Too many 1s
            while (ones > k) {
                if (s.charAt(low) == '1') {
                    ones--;
                }
                low++;
            }

            // Remove useless leading zeroes
            while (low <= high &&
                   s.charAt(low) == '0') {
                low++;
            }

            // We have exactly k ones
            if (ones == k) {

                int len = high - low + 1;

                if (len < bestLen) {
                    bestLen = len;
                    bestStart = low;
                }
                else if (len == bestLen) {

                    String current = s.substring(low, high + 1);
                    String best = s.substring(
                        bestStart,
                        bestStart + bestLen
                    );

                    if (current.compareTo(best) < 0) {
                        bestStart = low;
                    }
                }
            }
        }

        if (bestStart == -1) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLen);
    }
}