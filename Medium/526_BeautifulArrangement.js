/**
 * @param {number} n
 * @return {number}
 * Reference solution #3
 * Backtracking, need to use an array to tack used numbers
 * Time complexity: O(k). k refers to the number of valid permutation. 
 * Space complexity: O(n). Visited array of size n is used. The depth of recursion
 * tree will also go upto n. Here, n refers to the given integer n.
 */


const countArrangement = (n) => {
    const countObj = { count: 0 };
    let visited = new Array(n + 1).fill(false);
    for (let i = 0; i < visited.length; i++) {
        visited[i] = false;
    }
    dfs(countObj, n, 1, visited);
    return countObj.count;
    ;
};

const dfs = (countObj, n, currentValue, visited) => {
    if (currentValue === n + 1) {
        countObj.count++;
        return;
    }
    for (let i = 1; i <= n; i++) {
        if (!visited[i] && (currentValue % i === 0 || i % currentValue === 0)) {
            visited[i] = true;
            dfs(countObj, n, currentValue + 1, visited);
            visited[i] = false;
        }
    }
}
