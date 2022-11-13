// bottom-up DP with rolling array
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }

        return memo[n % 2];
    }
}

// bottom-up DP
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }
}

// top down memorized DP
class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return fibHelper(n, memo);
    }

    private int fibHelper(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int f = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        memo[n] = f;

        return f;
    }
}

// recursion
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}