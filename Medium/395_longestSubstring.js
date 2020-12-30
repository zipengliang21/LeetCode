/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 * The following is the Brute-Force way...
 * Generate all the possible substring, and check whether it's valid;
 * Then, take the longest one and return its length.
 */
let longestSubstring = function (s, k) {
    let longestSubs = 0;
    for (let i = 0; i < s.length; i++) {
        for (let j = 0; j <= s.length; j++) {
            let sub = s.substring(i, j);
            let subMap = createMap(sub);
            if (isValidSubstring(subMap, k) && longestSubs < sub.length) {
                longestSubs = sub.length
            }
        }
    }
    return longestSubs;
};

let createMap = (s) => {
    let repeatChar = new Map();
    for (const c of s) {
        if (repeatChar.get(c)) {
            let old = repeatChar.get(c);
            repeatChar.set(c, old + 1);
        } else {
            repeatChar.set(c, 1);
        }
    }
    return repeatChar;
}

let isValidSubstring = (subMap, k) => {
    let isValid = true;
    subMap.forEach((value) => {
        if (value < k) {
            isValid = false;
        }
    });
    return isValid;
}

/**
 * Sliding Window Approach
 * public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}

 */