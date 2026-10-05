class Solution {
    public int minRotations(int n, String s) {
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        int[] pref = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            int dist = Math.abs(curr - digits[i]);
            pref[i] = Math.min(dist, 10 - dist);
            if (i > 0) {
                pref[i] += pref[i - 1];
            }
            curr = digits[i];
        }

        int[] suff = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int dist = Math.abs(digits[i + 1] - digits[i]);
            suff[i] = suff[i + 1] + Math.min(dist, 10 - dist);
        }

        int minTotalCost = pref[n - 1];

        for (int k = 0; k < n; k++) {
            int currentCost = 0;

            if (k == 0) {
                int initialDist = Math.abs(0 - digits[n - 1]);
                currentCost = Math.min(initialDist, 10 - initialDist) + suff[0];
            } else {
                currentCost += pref[k - 1];
                int bridgeDist = Math.abs(digits[k - 1] - digits[n - 1]);
                currentCost += Math.min(bridgeDist, 10 - bridgeDist);

                currentCost += suff[k];
            }

            minTotalCost = Math.min(minTotalCost, currentCost);
        }

        return minTotalCost;
    }
}