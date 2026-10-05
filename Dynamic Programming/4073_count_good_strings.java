class Solution {
    private static final long MOD = 1_000_000_007;

    public int countGoodStrings(long n) {
        if (n == 0) return 0;
        
        long[][] T = {
            {1, 1},
            {1, 0}
        };

        long[][] Rn = matrixPower(T, n);
        
        long fn = Rn[1][0];
        
        long result = (2 * fn) % MOD;
        
        return (int) result;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        long[][] res = {
            {1, 0},
            {0, 1}
        }; // Identity matrix
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = (C[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;
                }
            }
        }
        return C;
    }
}