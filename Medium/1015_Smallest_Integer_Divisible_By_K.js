/**
 * @param {number} K
 * @return {number}
 * My solution
 */
let smallestRepunitDivByK = function (K) {
    // If K is divisible by 2 or 5, then there's no such N
    if (K % 2 === 0 || K % 5 === 0) {
        return -1;
    }

    // otherwise, N exists, 
    // and we use a brute force way to obtain it
    let length = 1;
    let remainder = 1;
    while (true) {
        if (remainder % K !== 0) {
            length++;
            remainder = (10 * remainder + 1) % K;
        } else {
            return length;
        }
    }
};

/**
 * Reference Solution in JAVA:
 * class Solution {
    public int smallestRepunitDivByK(int K) {
        int remainder = 0;
        for (int length_N = 1; length_N <= K; length_N++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}

Notes: Now we have an algorithm that can solve the problem.

Furthermore, we can improve this algorithm with Pigeonhole Principle.
Recall that the number of possible values of remainder (ranging from 0 to K-1) is limited,
and in fact, the number is K. As a result, if the while-loop continues more than K times,
and haven't stopped, then we can conclude that remainder
repeats -- you can not have more than K different remainder.

Hence, if N exists, the while-loop must return length_N in the first K loops. Otherwise, it goes into an infinite loop.

Therefore, we can just run the while-loop K times, and return -1 if not stopped.

There are a few interesting points worth pointing out in the code above:

We initialize remainder to 0, not 1, to keep code consistency because in the first loop the remainder changes to 1.
You can also initialize it as 1, but it requires a little change in code.
We only run the loop K times at most, not K+1. This is because if it does not stop in the previous K loop,
it will continue the K+1-th iteration, which must have repeated remainder.
Therefore, it is not necessary to check the K+1-th iteration.
Also, note that 111...111 can never be divided by 2 or 5 because its last digit is never an even number or 5.
You can just return -1 if you find that 2 or 5 is a factor of K.

Complexity Analysis

Time Complexity : O(K) since we at most run the loop O(K) times.

Space Complexity : O(1) since we only use three ints: K, remainder, and length_N.
 */