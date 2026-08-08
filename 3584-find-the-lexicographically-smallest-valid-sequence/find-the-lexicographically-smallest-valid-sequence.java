import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // Step 1: Build "last" array
        // last[j] = rightmost index i in word1 such that word2[j..m-1]
        // can be matched exactly (no changes) starting from i onward.
        int[] last = new int[m];
        Arrays.fill(last, -1);

        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        // If j >= 0 here, it means some suffix of word2 never got matched
        // at all (last[j] stayed -1 for it) — that's fine, we still try
        // the greedy pass; it'll naturally fail if truly impossible.

        // Step 2: Greedy left-to-right match, allowed ONE change
        int[] result = new int[m];
        int wi = 0;      // pointer in word1
        int wj = 0;      // pointer in word2
        boolean changed = false;

        while (wi < n && wj < m) {
            if (word1.charAt(wi) == word2.charAt(wj)) {
                // exact match — always free, always take it
                result[wj] = wi;
                wj++;
                wi++;
            } else {
                // mismatch — decide whether to spend the 1 allowed change
                boolean canChange = !changed &&
                        (wj == m - 1 || (last[wj + 1] != -1 && last[wj + 1] > wi));

                if (canChange) {
                    result[wj] = wi;
                    changed = true;
                    wj++;
                    wi++;
                } else {
                    // skip this char in word1, keep looking
                    wi++;
                }
            }
        }

        if (wj == m) {
            return result; // found valid sequence
        } else {
            return new int[0]; // impossible
        }
    }
}