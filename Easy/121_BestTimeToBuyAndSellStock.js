/**
 * @param {number[]} prices
 * @return {number}
 * Runtime: 80 ms,
 * Memory Usage: 39.2 MB,
 */
let maxProfit = function (prices) {
    if (prices.length === 0) return 0;
    let buyPrice = prices[0];
    let sellPrice = prices[0];
    let result = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > sellPrice) {
            sellPrice = prices[i];
        } else if (prices[i] < buyPrice) {
            result = Math.max(result, sellPrice - buyPrice);
            buyPrice = prices[i];
            sellPrice = prices[i];
        }
    }
    return Math.max(result, sellPrice - buyPrice);
};

//--------------------------------------------------
/**
 * @param {number[]} prices
 * @return {number}
 * The following has less code than above way
 * 
 * Runtime: 80 ms, faster than 85.69% of JavaScript 
 * online submissions for Best Time to Buy and Sell Stock.
 * 
 * Memory Usage: 41.3 MB, less than 7.87% of JavaScript 
 * online submissions for Best Time to Buy and Sell Stock.
 */
let maxProfit = function (prices) {
    let max = 0;
    let buy = Number.MAX_SAFE_INTEGER;
    for (const price of prices) {
        if (price < buy) {
            buy = price;
        } else if (price - buy > max) {
            max = price - buy;
        }
    }
    return max;
};